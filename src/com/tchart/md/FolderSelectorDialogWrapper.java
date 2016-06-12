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
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.List;

import com.afollestad.materialdialogs.MaterialDialog;
import com.tchart.md.Utils;

@SuppressWarnings("deprecation")
@BA.ShortName("MD_FolderSelectorDialog")
@ActivityObject

@Events(values={"ButtonPress(Result As Int)", "Show", "Cancel", "Dismiss","FolderSelection(Result As String)"})

public class FolderSelectorDialogWrapper
{	
	private BA ba;
	private String EventName;
	private MaterialDialog.Builder MD;
	
	private File parentFolder;
	private File[] parentContents;
	private boolean canGoUp = true;
		
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
					if (ba.subExists(EventName + "_folderselection")) ba.raiseEventFromUI(this, EventName + "_folderselection", parentFolder.getPath());
					dialog.dismiss();
                }
				
				@Override
				public void onNegative(MaterialDialog dialog)
				{
					ba.raiseEventFromUI(this, EventName + "_buttonpress", -1);
					dialog.dismiss();
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
	
	public void Show(String InitialFolder)
	{
		File InitialFolderTest = new File(InitialFolder);
		if (InitialFolderTest.exists())
		{
			parentFolder = InitialFolderTest;
		}
		else
		{
			parentFolder = Environment.getExternalStorageDirectory();
		}
		parentContents = listFiles();
		
		//if (ba.subExists(EventName + "_listcallback"))
		//{
		MD.itemsCallback(new MaterialDialog.ListCallback()
		{
			@Override
			public void onSelection(MaterialDialog dialog, View view, int which, CharSequence text)
			{
				if (canGoUp && which == 0) {
					parentFolder = parentFolder.getParentFile();
					canGoUp = parentFolder.getParent() != null;
				} else {
					parentFolder = parentContents[canGoUp ? which - 1 : which];
					canGoUp = true;
				}
				parentContents = listFiles();
	
				dialog.setTitle(parentFolder.getAbsolutePath());
				dialog.setItems(getContentsArray());					
			}
		}
		);
		//}
		
		MD.title(parentFolder.getAbsolutePath());
		MD.items(getContentsArray());	
		MD.autoDismiss(false);
		MD.positiveText(android.R.string.ok);
		MD.negativeText(android.R.string.cancel);
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
	
	String[] getContentsArray()
	{
		ba.Log("getContentsArray");
		String[] results = new String[parentContents.length + (canGoUp ? 1 : 0)];
		if (canGoUp) results[0] = "...";
		for (int i = 0; i < parentContents.length; i++)
			results[canGoUp ? i + 1 : i] = parentContents[i].getName();
		return results;
	}

	File[] listFiles()
	{
		ba.Log("listFiles");
		File[] contents = parentFolder.listFiles();
		java.util.List<File> results = new ArrayList<>();
		for (File fi : contents)
		{
			if (fi.isDirectory()) results.add(fi);
		}
		Collections.sort(results, new FolderSorter());
		return results.toArray(new File[results.size()]);
	}
	
	private static class FolderSorter implements Comparator<File>
	{
		//@Override
		public int compare(File lhs, File rhs)
		{
			return lhs.getName().compareTo(rhs.getName());
		}
	}
}
