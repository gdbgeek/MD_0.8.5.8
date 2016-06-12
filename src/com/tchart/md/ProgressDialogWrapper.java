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
import com.afollestad.materialdialogs.GravityEnum;
import com.tchart.md.Utils;

@SuppressWarnings("deprecation")
@BA.ShortName("MD_ProgressDialog")
@ActivityObject

@Events(values={"ButtonPress(Result As Int)", "Show", "Cancel", "Dismiss"})

public class ProgressDialogWrapper
{	
	private BA ba;
	private String EventName;
	private MaterialDialog.Builder MD;
	MaterialDialog dialog;
	private boolean isOpen = false;
		
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
	
	public void Show(String title, String content, String negativeText, Boolean Indeterminate, int Max, Boolean showMinMax)
	{
		if (title.length() > 0) MD.title(title);
		if (content.length() > 0) MD.content(content);
		if (negativeText.length() > 0) MD.negativeText(negativeText);
		
		if (Indeterminate)
		{
			MD.progress(true, 0);			         
		}		
		else
		{
			MD.progress(false, Max, showMinMax);
			MD.contentGravity(GravityEnum.CENTER);
		}
		
		dialog = MD.show(); 
		
		isOpen = true;
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
	
	public void Dismiss()
	{
		if (isOpen)
		{
			dialog.dismiss();
			isOpen = false;
		}
	}
	
	public void IncrementProgress(int Increment)
	{
		if (isOpen)
		{
			if (dialog.getCurrentProgress() == dialog.getMaxProgress())
			{
				dialog.setContent("Done!");
				isOpen = false;
				dialog.dismiss();				
			}
			else
			{			
				dialog.incrementProgress(Increment);
			}			
		}
	}
	
	public int CurrentProgress()
	{
		if (isOpen) return dialog.getCurrentProgress();
		return 0;
	}
}
