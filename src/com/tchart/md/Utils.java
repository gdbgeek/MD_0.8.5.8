package com.tchart.md;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BA.ShortName;
import anywheresoftware.b4a.BA.Hide;
import anywheresoftware.b4a.objects.collections.Map;
import anywheresoftware.b4a.objects.collections.List;

import java.util.ArrayList;
import java.io.File;

import android.content.Context;
import android.util.DisplayMetrics;

@SuppressWarnings("deprecation")
@BA.ShortName("Utils")

@Hide
public class Utils
{	
	/*
	private java.util.List B4AList2JavaList(List items)
	{
		java.util.List<String> L = new ArrayList<String>();		
		for(int i =0;i < items.getSize();i++)
		{
			L.add((String) items.Get(i));
		}
		return L;
	}*/
	
	public static java.util.List B4AList2JavaList(List items)
	{
		java.util.List L = new ArrayList();		
		for(int i =0;i < items.getSize();i++) L.add(items.Get(i));
		return L;
	}
	
	public List JavaList2B4AList(java.util.List items)
	{
		List L = new List();
		L.Initialize();
		for (int i =0;i < items.size();i++) L.Add(items.get(i));
		return L;
	}
	
	public static CharSequence[] B4AList2CharSequence(List items)
	{
		java.util.List<String> listItems = B4AList2JavaList(items);
		return listItems.toArray(new CharSequence[listItems.size()]);
	}
	
	public String[] CharSequence2String(CharSequence[] items)
	{
		String[] Strings = new String[items.length];		
		for (int i =0;i < items.length;i++) Strings[i] = items[i].toString();
		return Strings;
	}
	
	public Integer[] int2Integer(int[] ints)
	{
		Integer[] Integers = new Integer[ints.length];		
		for(int ctr = 0; ctr < ints.length; ctr++) Integers[ctr] = Integer.valueOf(ints[ctr]);		
		return Integers;
	}
	
	public int[] Integer2int(Integer[] integers)
	{
		int[] ints = new int[integers.length];		
		for(int ctr = 0; ctr < integers.length; ctr++) ints[ctr] = integers[ctr].intValue();		
		return ints;
	}
	
	public static Integer[] MapBool2Integer(Map m)
	{
		int s = 0;
		for(int i =0;i < m.getSize();i++) if ((boolean)m.GetValueAt(i) == true) s++;
			
		Integer[] ints = new Integer[s];
		int c = 0;
		
		for(int i =0;i < m.getSize();i++)
		{
			if ((boolean)m.GetValueAt(i) == true)
			{
				ints[c] = i;
				c++;
			}
		}
		
		return ints;
	}
	
	/*
	private CharSequence[] B4AMap2CharSequence(Map m)
	{
		java.util.List<String> listItems = B4AList2JavaList(m);
		return listItems.toArray(new CharSequence[listItems.size()]);
	}
	*/
	
	public static List B4AMapKeys2B4AList(Map m)
	{
		List L = new List();
		L.Initialize();
		for (int i =0;i < m.getSize();i++) L.Add(m.GetKeyAt(i));
		return L;
	}
	
	public static List B4AMapValues2B4AList(Map m)
	{
		List L = new List();
		L.Initialize();
		for (int i =0;i < m.getSize();i++) L.Add(m.GetValueAt(i));
		return L;
	}
	
	/*
	private Map Arrays2Map(int[] ints,CharSequence[] items)
	{
		Map M = new Map();
		M.Initialize();
	}
	*/
	 /**
     * DESCRIPTION:
     * Convert pixels to device independent pixels.
     * @param px - pixels
     * @return device independent pixels.
     */
    //public static float convertPixelsToDp(int px){
    //    DisplayMetrics metrics = App.getContext().getResources().getDisplayMetrics();
    //    float dp = px / (metrics.densityDpi / 160f);
    //    return dp;
    //}
    
    /**
     * DESCRIPTION:
     * Convert device independent pixels to pixels. 
     * @param dp - device independent pixels.
     * @return pixels.
     */
    //public static int convertDpToPixel(float dp){
    //    DisplayMetrics metrics = App.getContext().getResources().getDisplayMetrics();
    //    int px = (int) (dp * (metrics.densityDpi / 160f));
    //   return px;
    //}
}
