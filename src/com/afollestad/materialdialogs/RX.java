package com.afollestad.materialdialogs;

import anywheresoftware.b4a.BA;
import java.lang.reflect.Field;

public class RX {
	public static final class dimen {
		public static int md_bg_corner_radius = BA.applicationContext.getResources().getIdentifier("md_bg_corner_radius", "dimen", BA.packageName);
		public static int md_icon_max_size = BA.applicationContext.getResources().getIdentifier("md_icon_max_size", "dimen", BA.packageName);
		public static int md_dialog_frame_margin = BA.applicationContext.getResources().getIdentifier("md_dialog_frame_margin", "dimen", BA.packageName);
		public static int md_content_padding_top = BA.applicationContext.getResources().getIdentifier("md_content_padding_top", "dimen", BA.packageName);
		public static int md_content_padding_bottom = BA.applicationContext.getResources().getIdentifier("md_content_padding_bottom", "dimen", BA.packageName);
		public static int md_colorchooser_circlesize = BA.applicationContext.getResources().getIdentifier("md_colorchooser_circlesize", "dimen", BA.packageName);
		public static int md_notitle_vertical_padding = BA.applicationContext.getResources().getIdentifier("md_notitle_vertical_padding", "dimen", BA.packageName);
		public static int md_button_frame_vertical_padding = BA.applicationContext.getResources().getIdentifier("md_button_frame_vertical_padding", "dimen", BA.packageName);
		public static int md_button_padding_frame_side = BA.applicationContext.getResources().getIdentifier("md_button_padding_frame_side", "dimen", BA.packageName);
		public static int md_button_height = BA.applicationContext.getResources().getIdentifier("md_button_height", "dimen", BA.packageName);
		public static int md_divider_height = BA.applicationContext.getResources().getIdentifier("md_divider_height", "dimen", BA.packageName);
		public static int md_neutral_button_margin = BA.applicationContext.getResources().getIdentifier("md_neutral_button_margin", "dimen", BA.packageName);
	}
	public static final class layout {
		public static int md_dialog_custom = BA.applicationContext.getResources().getIdentifier("md_dialog_custom", "layout", BA.packageName);
		public static int md_dialog_list = BA.applicationContext.getResources().getIdentifier("md_dialog_list", "layout", BA.packageName);
		public static int md_dialog_progress = BA.applicationContext.getResources().getIdentifier("md_dialog_progress", "layout", BA.packageName);
		public static int md_dialog_progress_indeterminate_horizontal = BA.applicationContext.getResources().getIdentifier("md_dialog_progress_indeterminate_horizontal", "layout", BA.packageName);
		public static int md_dialog_progress_indeterminate = BA.applicationContext.getResources().getIdentifier("md_dialog_progress_indeterminate", "layout", BA.packageName);
		public static int md_dialog_input = BA.applicationContext.getResources().getIdentifier("md_dialog_input", "layout", BA.packageName);
		public static int md_dialog_basic = BA.applicationContext.getResources().getIdentifier("md_dialog_basic", "layout", BA.packageName);
		public static int md_listitem = BA.applicationContext.getResources().getIdentifier("md_listitem", "layout", BA.packageName);
		public static int md_listitem_singlechoice = BA.applicationContext.getResources().getIdentifier("md_listitem_singlechoice", "layout", BA.packageName);
		public static int md_listitem_multichoice = BA.applicationContext.getResources().getIdentifier("md_listitem_multichoice", "layout", BA.packageName);
		public static int md_dialog_colorchooser = BA.applicationContext.getResources().getIdentifier("md_dialog_colorchooser", "layout", BA.packageName);
		public static int md_stub_inputpref = BA.applicationContext.getResources().getIdentifier("md_stub_inputpref", "layout", BA.packageName);
		public static int md_preference_custom = BA.applicationContext.getResources().getIdentifier("md_preference_custom", "layout", BA.packageName);
		public static int md_simplelist_item = BA.applicationContext.getResources().getIdentifier("md_simplelist_item", "layout", BA.packageName);
	}
	public static final class attr {
		public static int md_dark_theme = BA.applicationContext.getResources().getIdentifier("md_dark_theme", "attr", BA.packageName);
		public static int md_background_color = BA.applicationContext.getResources().getIdentifier("md_background_color", "attr", BA.packageName);
		public static int md_positive_color = BA.applicationContext.getResources().getIdentifier("md_positive_color", "attr", BA.packageName);
		public static int md_neutral_color = BA.applicationContext.getResources().getIdentifier("md_neutral_color", "attr", BA.packageName);
		public static int md_negative_color = BA.applicationContext.getResources().getIdentifier("md_negative_color", "attr", BA.packageName);
		public static int md_widget_color = BA.applicationContext.getResources().getIdentifier("md_widget_color", "attr", BA.packageName);
		public static int md_title_color = BA.applicationContext.getResources().getIdentifier("md_title_color", "attr", BA.packageName);
		public static int md_content_color = BA.applicationContext.getResources().getIdentifier("md_content_color", "attr", BA.packageName);
		public static int md_item_color = BA.applicationContext.getResources().getIdentifier("md_item_color", "attr", BA.packageName);
		public static int md_icon = BA.applicationContext.getResources().getIdentifier("md_icon", "attr", BA.packageName);
		public static int md_icon_max_size = BA.applicationContext.getResources().getIdentifier("md_icon_max_size", "attr", BA.packageName);
		public static int md_icon_limit_icon_to_default_size = BA.applicationContext.getResources().getIdentifier("md_icon_limit_icon_to_default_size", "attr", BA.packageName);
		public static int md_divider = BA.applicationContext.getResources().getIdentifier("md_divider", "attr", BA.packageName);
		public static int md_divider_color = BA.applicationContext.getResources().getIdentifier("md_divider_color", "attr", BA.packageName);
		public static int textAllCaps = BA.applicationContext.getResources().getIdentifier("textAllCaps", "attr", BA.packageName);
		public static int md_list_selector = BA.applicationContext.getResources().getIdentifier("md_list_selector", "attr", BA.packageName);
		public static int md_btn_stacked_selector = BA.applicationContext.getResources().getIdentifier("md_btn_stacked_selector", "attr", BA.packageName);
		public static int md_btn_positive_selector = BA.applicationContext.getResources().getIdentifier("md_btn_positive_selector", "attr", BA.packageName);
		public static int md_btn_neutral_selector = BA.applicationContext.getResources().getIdentifier("md_btn_neutral_selector", "attr", BA.packageName);
		public static int md_btn_negative_selector = BA.applicationContext.getResources().getIdentifier("md_btn_negative_selector", "attr", BA.packageName);
		public static int colorAccent = BA.applicationContext.getResources().getIdentifier("colorAccent", "attr", BA.packageName);
		public static int md_link_color = BA.applicationContext.getResources().getIdentifier("md_link_color", "attr", BA.packageName);
		public static int md_btn_ripple_color = BA.applicationContext.getResources().getIdentifier("md_btn_ripple_color", "attr", BA.packageName);
		public static int colorControlHighlight = BA.applicationContext.getResources().getIdentifier("colorControlHighlight", "attr", BA.packageName);
		public static int md_title_gravity = BA.applicationContext.getResources().getIdentifier("md_title_gravity", "attr", BA.packageName);
		public static int md_content_gravity = BA.applicationContext.getResources().getIdentifier("md_content_gravity", "attr", BA.packageName);
		public static int md_btnstacked_gravity = BA.applicationContext.getResources().getIdentifier("md_btnstacked_gravity", "attr", BA.packageName);
		public static int md_items_gravity = BA.applicationContext.getResources().getIdentifier("md_items_gravity", "attr", BA.packageName);
		public static int md_buttons_gravity = BA.applicationContext.getResources().getIdentifier("md_buttons_gravity", "attr", BA.packageName);
		public static int md_medium_font = BA.applicationContext.getResources().getIdentifier("md_medium_font", "attr", BA.packageName);
		public static int md_regular_font = BA.applicationContext.getResources().getIdentifier("md_regular_font", "attr", BA.packageName);
		public static int colorControlNormal = BA.applicationContext.getResources().getIdentifier("colorControlNormal", "attr", BA.packageName);
	}
	public static final class color {
		public static int md_material_blue_600 = BA.applicationContext.getResources().getIdentifier("md_material_blue_600", "color", BA.packageName);
		public static int md_edittext_error = BA.applicationContext.getResources().getIdentifier("md_edittext_error", "color", BA.packageName);
	}
	public static final class style {
		public static int MD_Dark = BA.applicationContext.getResources().getIdentifier("MD_Dark", "style", BA.packageName);
		public static int MD_Light = BA.applicationContext.getResources().getIdentifier("MD_Light", "style", BA.packageName);
	}
	public static final class styleable {
		public static int[] MDRootLayout = getResourceDeclareStyleableIntArray("MDRootLayout");
		public static int MDRootLayout_md_reduce_padding_no_title_no_buttons = BA.applicationContext.getResources().getIdentifier("MDRootLayout_md_reduce_padding_no_title_no_buttons", "styleable", BA.packageName);
		public static int[] Preference = getResourceDeclareStyleableIntArray("Preference");
		public static int Preference_useStockLayout = BA.applicationContext.getResources().getIdentifier("Preference_useStockLayout", "styleable", BA.packageName);
	}
	public static final class drawable {
		public static int md_transparent = BA.applicationContext.getResources().getIdentifier("md_transparent", "drawable", BA.packageName);
		public static int abc_btn_radio_material = BA.applicationContext.getResources().getIdentifier("abc_btn_radio_material", "drawable", BA.packageName);
		public static int abc_btn_check_material = BA.applicationContext.getResources().getIdentifier("abc_btn_check_material", "drawable", BA.packageName);
	}
	public static final class id {
		public static int title = BA.applicationContext.getResources().getIdentifier("title", "id", BA.packageName);
		public static int control = BA.applicationContext.getResources().getIdentifier("control", "id", BA.packageName);
		public static int icon = BA.applicationContext.getResources().getIdentifier("icon", "id", BA.packageName);
		public static int titleFrame = BA.applicationContext.getResources().getIdentifier("titleFrame", "id", BA.packageName);
		public static int content = BA.applicationContext.getResources().getIdentifier("content", "id", BA.packageName);
		public static int contentListView = BA.applicationContext.getResources().getIdentifier("contentListView", "id", BA.packageName);
		public static int buttonDefaultPositive = BA.applicationContext.getResources().getIdentifier("buttonDefaultPositive", "id", BA.packageName);
		public static int buttonDefaultNeutral = BA.applicationContext.getResources().getIdentifier("buttonDefaultNeutral", "id", BA.packageName);
		public static int buttonDefaultNegative = BA.applicationContext.getResources().getIdentifier("buttonDefaultNegative", "id", BA.packageName);
		public static int root = BA.applicationContext.getResources().getIdentifier("root", "id", BA.packageName);
		public static int customViewFrame = BA.applicationContext.getResources().getIdentifier("customViewFrame", "id", BA.packageName);
		public static int label = BA.applicationContext.getResources().getIdentifier("label", "id", BA.packageName);
		public static int minMax = BA.applicationContext.getResources().getIdentifier("minMax", "id", BA.packageName);
		public static int grid = BA.applicationContext.getResources().getIdentifier("grid", "id", BA.packageName);
		public static int colorChooserCustomFrame = BA.applicationContext.getResources().getIdentifier("colorChooserCustomFrame", "id", BA.packageName);
		public static int hexInput = BA.applicationContext.getResources().getIdentifier("hexInput", "id", BA.packageName);
		public static int colorIndicator = BA.applicationContext.getResources().getIdentifier("colorIndicator", "id", BA.packageName);
		public static int colorA = BA.applicationContext.getResources().getIdentifier("colorA", "id", BA.packageName);
		public static int colorAValue = BA.applicationContext.getResources().getIdentifier("colorAValue", "id", BA.packageName);
		public static int colorR = BA.applicationContext.getResources().getIdentifier("colorR", "id", BA.packageName);
		public static int colorRValue = BA.applicationContext.getResources().getIdentifier("colorRValue", "id", BA.packageName);
		public static int colorG = BA.applicationContext.getResources().getIdentifier("colorG", "id", BA.packageName);
		public static int colorGValue = BA.applicationContext.getResources().getIdentifier("colorGValue", "id", BA.packageName);
		public static int colorB = BA.applicationContext.getResources().getIdentifier("colorB", "id", BA.packageName);
		public static int colorBValue = BA.applicationContext.getResources().getIdentifier("colorBValue", "id", BA.packageName);
		public static int colorALabel = BA.applicationContext.getResources().getIdentifier("colorALabel", "id", BA.packageName);
	}
	public static final class string {
		public static int md_done_label = BA.applicationContext.getResources().getIdentifier("md_done_label", "string", BA.packageName);
		public static int md_back_label = BA.applicationContext.getResources().getIdentifier("md_back_label", "string", BA.packageName);
		public static int md_cancel_label = BA.applicationContext.getResources().getIdentifier("md_cancel_label", "string", BA.packageName);
		public static int md_custom_label = BA.applicationContext.getResources().getIdentifier("md_custom_label", "string", BA.packageName);
		public static int md_presets_label = BA.applicationContext.getResources().getIdentifier("md_presets_label", "string", BA.packageName);
		public static int md_error_label = BA.applicationContext.getResources().getIdentifier("md_error_label", "string", BA.packageName);
		public static int md_storage_perm_error = BA.applicationContext.getResources().getIdentifier("md_storage_perm_error", "string", BA.packageName);
		public static int md_choose_label = BA.applicationContext.getResources().getIdentifier("md_choose_label", "string", BA.packageName);
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
