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
//import com.afollestad.materialdialogs.Theme;
//import com.afollestad.materialdialogs.ThemeSingleton;

import com.tchart.md.Utils;
import com.tchart.md.MD_Theme;

import me.zhanghai.android.materialprogressbar.HorizontalProgressDrawable;
import me.zhanghai.android.materialprogressbar.IndeterminateHorizontalProgressDrawable;
import me.zhanghai.android.materialprogressbar.IndeterminateProgressDrawable;

@SuppressWarnings("deprecation")
@BA.ShortName("MD_BasicDialog")
@BA.Author("Trevor Hart")
@DependsOn(values={"android-support-v4","android-support-v7-appcompat","android-support-v7-recyclerview"})
@Permissions(values = {"android.permission.READ_EXTERNAL_STORAGE"})
@Version(0.858f)
@ActivityObject

@Events(values={"ButtonPress(Result As Int)", "Show", "Cancel", "Dismiss"})

//Show()
//Cancel()
//Dismiss()
//Selection
//ButtonPress(Result as Int)
//ItemSelected(Index as Int,Text as String)
//SingleChoice(Index as Int,Text as String)
//MultiChoice(Result as Map)
//ColorSelection
//OptionsItemSelected
//FolderSelection(Result as String)
//Input(Result as String)

//_show
//_cancel
//_dismiss
//_selection
//_buttonpress
//_itemselected
//_singlechoice
//_multichoice
//_colorselection
//_optionsitemselected
//_folderselection
//_input

public class MaterialDialogsWrapper
{	
	private BA ba;
	private String EventName;
	private MaterialDialog.Builder MD;
	
	/**
	*This is a B4A wrapper library of Aidan Follestads Material Dialogs library on GitHub
	*
	*MD_BasicDialog is a basic dialog
	*MD_InputDialog is an input dialog
	*MD_ListDialog is a list dialog showing items	
	*MD_MultiChoiceDialog is a choice dialog showing items and allowing multiple selections
	*MD_SingleChoiceDialog is a choice dialog showing items and allowing a single selections
	*MD_FolderSelectorDialog is a folder selection dialog
	*MD_ProgressDialog is a progress dialog
	*
	*/
	public static void LIBRARY_DOC()
	{
	}
		
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
		
		if (ba.subExists(EventName + "_oncancel"))
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
	
	public void Show(String title, String content, String positiveText, String negativeText, String neutralText, Bitmap icon, boolean limitIconToDefaultSize, boolean forceStacking)
	{		
		if (title.length() > 1) MD.title(title);
		if (content.length() > 1) MD.content(content);
		if (positiveText.length() > 1) MD.positiveText(positiveText);
		if (negativeText.length() > 1) MD.negativeText(negativeText);		
		if (neutralText.length() > 1) MD.neutralText(neutralText);
		
		if (icon != null)
		{
			BitmapDrawable bd = new BitmapDrawable(icon);
			MD.icon(bd);
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
