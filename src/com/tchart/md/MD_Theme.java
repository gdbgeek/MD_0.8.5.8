package com.tchart.md;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;

import android.graphics.Color;

import java.util.ArrayList;
import java.io.File;

@SuppressWarnings("deprecation")
@BA.ShortName("MD_Theme")

public class MD_Theme
{	
	private int ItitleColor = 999;
	private int IcontentColor = 999;
	private int IdividerColor = 999;
	private int IbackgroundColor = 999;
	private int IpositiveColor = 999;
	private int IneutralColor = 999;
	private int InegativeColor = 999;
	private int IwidgetColor = 999;
	
	public void settitleColor(int Color)
	{
		ItitleColor = Color;
	}
	
	public int gettitleColor()
	{
		return ItitleColor;
	}
	
	public void setcontentColor(int Color)
	{
		IcontentColor = Color;
	}
	
	public int getcontentColor()
	{
		return IcontentColor;
	}
	
	public void setdividerColor(int Color)
	{
		IdividerColor = Color;
	}
	
	public int getdividerColor()
	{
		return IdividerColor;
	}
	
	public void setbackgroundColor(int Color)
	{
		IbackgroundColor = Color;
	}
	
	public int getbackgroundColor()
	{
		return IbackgroundColor;
	}
	
	public void setpositiveColor(int Color)
	{
		IpositiveColor = Color;
	}
	
	public int getpositiveColor()
	{
		return IpositiveColor;
	}
	
	public void setneutralColor(int Color)
	{
		IneutralColor = Color;
	}
	
	public int getneutralColor()
	{
		return IneutralColor;
	}
	
	public void setnegativeColor(int Color)
	{
		InegativeColor = Color;
	}
	
	public int getnegativeColor()
	{
		return InegativeColor;
	}

	public void setwidgetColor(int Color)
	{
		IwidgetColor = Color;
	}
	
	public int getwidgetColor()
	{
		return IwidgetColor;
	}
	
	public void SeedThemeFromColor(int Color, boolean UseDarkTheme)
	{
		IwidgetColor = Color;
		IpositiveColor = IwidgetColor;
        InegativeColor = IwidgetColor;
        IneutralColor = IwidgetColor;
		
		if (UseDarkTheme == true)
		{
			//DARK Theme
			//Dark Background + Light Text
			ItitleColor = android.graphics.Color.parseColor("#FFFFFF");
			IcontentColor = android.graphics.Color.parseColor("#C7C7C7");
			IbackgroundColor = android.graphics.Color.parseColor("#424242");
		}
		else
		{
			//LIGHT Theme
			//Light Background + Dark Text
			ItitleColor = android.graphics.Color.parseColor("#1F1F1F");
			IcontentColor = android.graphics.Color.parseColor("#6D6D6D");
			IbackgroundColor = android.graphics.Color.parseColor("#EEEEEE");
		}
	}
}