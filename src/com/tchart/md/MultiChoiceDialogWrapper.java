package com.tchart.md;

import anywheresoftware.b4a.AbsObjectWrapper;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ActivityObject;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Version;
import anywheresoftware.b4a.BA.DependsOn;
import anywheresoftware.b4a.BA.Permissions;
import anywheresoftware.b4a.BA.Events;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.objects.collections.List;

import android.content.DialogInterface;
import android.view.View;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.io.File;

import com.afollestad.materialdialogs.MaterialDialog;
import com.tchart.md.Utils;

@SuppressWarnings("deprecation")
@BA.ShortName("MD_MultiChoiceDialog")
@ActivityObject

@Events(values={"ButtonPress(Result As Int)", "Show", "Cancel", "Dismiss","MultiChoice(Result As Map)"})

public class MultiChoiceDialogWrapper
{	
	private BA ba;
	private String EventName;
	private MaterialDialog.Builder MD;
		
	public void Initialize(final BA ba, final String EventName)
    {
		this.ba = ba;
		this.EventName = EventName;
		
		MD = new MaterialDialog.Builder(ba.context);
		
		if (ba.subExists(EventName + "_buttonpress"))
		{    	
			MD.callback(new MaterialDialog.ButtonCallback()
			{
				@Override
				public void onPositive(MaterialDialog dialog)
				{
					ba.raiseEventFromUI(this, EventName + "_buttonpress", 1);
                }
				
				@Override
				public void onNegative(MaterialDialog dialog)
				{
					ba.raiseEventFromUI(this, EventName + "_buttonpress", -1);
                }
				
				@Override
				public void onNeutral(MaterialDialog dialog)
				{
					ba.raiseEventFromUI(this, EventName + "_buttonpress", 0);
                }
			}
			);
		}
		
		if (ba.subExists(EventName + "_show"))
		{ 
			MD.showListener(new DialogInterface.OnShowListener()
			{
                @Override
                public void onShow(DialogInterface dialog)
				{
					ba.raiseEventFromUI(this, EventName + "_show");
                }
            }
			);
		}
		
		if (ba.subExists(EventName + "_cancel"))
		{ 
			MD.cancelListener(new DialogInterface.OnCancelListener()
			{
                @Override
                public void onCancel(DialogInterface dialog)
				{
					ba.raiseEventFromUI(this, EventName + "_cancel");
                }
            }
			);
		}
		
		if (ba.subExists(EventName + "_dismiss"))
		{ 
			MD.dismissListener(new DialogInterface.OnDismissListener()
			{
                @Override
                public void onDismiss(DialogInterface dialog)
				{
					ba.raiseEventFromUI(this, EventName + "_dismiss");
                }
            }
			);
		}		
    }	
	
	public void Show(String title, Map items, String positiveText, String negativeText)
	{
		final Map M = items;
		Integer[] selectedIndexes = Utils.MapBool2Integer(M);
		
		if (title.length() > 0) MD.title(title);		
		if (items.getSize() > 0) MD.items(Utils.B4AList2CharSequence(Utils.B4AMapKeys2B4AList(M)));
		if (positiveText.length() > 0) MD.positiveText(positiveText);
		if (negativeText.length() > 0) MD.negativeText(negativeText);	
		
		if (ba.subExists(EventName + "_multichoice"))
		{
			MD.itemsCallbackMultiChoice(selectedIndexes, new MaterialDialog.ListCallbackMultiChoice()
			{
                @Override
                public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text)
				{
					for(int i =0;i < M.getSize();i++) M.Put(M.GetKeyAt(i),false);					
					for(int ctr = 0; ctr < text.length; ctr++) M.Put(text[ctr].toString(),true);					
					ba.raiseEventFromUI(this, EventName + "_multichoice",M);
					return true; // allow selection
                }
            }
			);
		}
		
		MD.alwaysCallMultiChoiceCallback();
		MD.show();
    }
	
	public void SetTheme(MD_Theme MyTheme)
	{
		if (MyTheme.gettitleColor() < 1) MD.titleColor(MyTheme.gettitleColor());
		if (MyTheme.getcontentColor() < 1) MD.contentColor(MyTheme.getcontentColor());
		if (MyTheme.getdividerColor() < 1) MD.dividerColor(MyTheme.getdividerColor());
		if (MyTheme.getbackgroundColor() < 1) MD.backgroundColor(MyTheme.getbackgroundColor());
		if (MyTheme.getpositiveColor() < 1) MD.positiveColor(MyTheme.getpositiveColor());
		if (MyTheme.getneutralColor() < 1) MD.neutralColor(MyTheme.getneutralColor());
		if (MyTheme.getnegativeColor() < 1) MD.negativeColor(MyTheme.getnegativeColor());
		if (MyTheme.getwidgetColor() < 1) MD.widgetColor(MyTheme.getwidgetColor());
	}
}
