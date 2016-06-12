package me.zhanghai.android.materialprogressbar;

import anywheresoftware.b4a.BA;
import java.lang.reflect.Field;

public class RX {
	public static final class attr {
		public static int colorControlActivated = BA.applicationContext.getResources().getIdentifier("colorControlActivated", "attr", BA.packageName);
	}
	public static final class styleable {
		public static int[] MaterialProgressBar = getResourceDeclareStyleableIntArray("MaterialProgressBar");
		public static int MaterialProgressBar_mpb_progressStyle = BA.applicationContext.getResources().getIdentifier("MaterialProgressBar_mpb_progressStyle", "styleable", BA.packageName);
		public static int MaterialProgressBar_mpb_setBothDrawables = BA.applicationContext.getResources().getIdentifier("MaterialProgressBar_mpb_setBothDrawables", "styleable", BA.packageName);
		public static int MaterialProgressBar_mpb_useIntrinsicPadding = BA.applicationContext.getResources().getIdentifier("MaterialProgressBar_mpb_useIntrinsicPadding", "styleable", BA.packageName);
		public static int MaterialProgressBar_mpb_showTrack = BA.applicationContext.getResources().getIdentifier("MaterialProgressBar_mpb_showTrack", "styleable", BA.packageName);
		public static int MaterialProgressBar_android_tint = BA.applicationContext.getResources().getIdentifier("MaterialProgressBar_android_tint", "styleable", BA.packageName);
		public static int MaterialProgressBar_mpb_tintMode = BA.applicationContext.getResources().getIdentifier("MaterialProgressBar_mpb_tintMode", "styleable", BA.packageName);
	}
private static final int[] getResourceDeclareStyleableIntArray(String name)
{
    try
    {
        //use reflection to access the resource class
        Field[] fields2 = Class.forName(BA.packageName + ".R$styleable" ).getFields();

        //browse all fields
        for ( Field f : fields2 )
        {
            //pick matching field
            if ( f.getName().equals( name ) )
            {
                //return as int array
                int[] ret = (int[])f.get( null );
                return ret;
            }
        }
    }
    catch ( Throwable t )
    {
    }

    return null;
}
}
