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
import android.text.InputType;

import java.util.ArrayList;
import java.io.File;

import com.afollestad.materialdialogs.MaterialDialog;
import com.tchart.md.Utils;

@SuppressWarnings("deprecation")
@BA.ShortName("MD_InputDialog")
@ActivityObject

@Events(values={"ButtonPress(Result As Int)", "Show", "Cancel", "Dismiss","Input(Result As String)"})

public class InputDialogWrapper
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
	
	public void Show(String title, String content, String hint, String prefill, boolean allowEmptyInput, int inputMaxLength, String positiveText, String negativeText, String neutralText, Bitmap icon, boolean limitIconToDefaultSize, boolean forceStacking)
	{
		if (title.length() > 0) MD.title(title);
		if (content.length() > 0) MD.content(content);
		if (positiveText.length() > 0) MD.positiveText(positiveText);
		if (negativeText.length() > 0) MD.negativeText(negativeText);		
		if (neutralText.length() > 0) MD.neutralText(neutralText);		
		
		if (icon != null)
		{
			BitmapDrawable bd = new BitmapDrawable(icon);
			MD.icon(bd);
		}
		
		MD.inputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PERSON_NAME | InputType.TYPE_TEXT_FLAG_CAP_WORDS);
		
		if (inputMaxLength > 0)
		{
			MD.inputMaxLength(inputMaxLength);
		}
		
		if (ba.subExists(EventName + "_input"))
		{
			MD.input((CharSequence)hint, (CharSequence)prefill, allowEmptyInput, new MaterialDialog.InputCallback()
			{
                @Override
                public void onInput(MaterialDialog dialog, CharSequence input)
				{
					ba.raiseEventFromUI(this, EventName + "_input",input.toString());
                }
			}
			);			
		}
		else
		{
			MD.input((CharSequence)hint, (CharSequence)prefill, allowEmptyInput, null);
		}
		
		MD.forceStacking(forceStacking);		
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
