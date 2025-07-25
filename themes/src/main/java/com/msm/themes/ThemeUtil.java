package com.msm.themes;



import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;


import com.msm.themes.model.Theme;

import java.util.ArrayList;
import java.util.List;


public class ThemeUtil {
    public static final String MyPrefTheme = "MyPrefTheme";

    public static final int THEME_RED = 0;
    public static final int THEME_PINK = 1;
    public static final int THEME_PURPLE = 2;
    public static final int THEME_DEEPPURPLE = 3;
    public static final int THEME_INDIGO = 4;
    public static final int THEME_BLUE = 5;
    public static final int THEME_LIGHTBLUE = 6;
    public static final int THEME_CYAN = 7;
    public static final int THEME_TEAL = 8;
    public static final int THEME_GREEN = 9;
    public static final int THEME_LIGHTGREEN = 10;
    public static final int THEME_LIME = 11;
    public static final int THEME_YELLOW = 12;
    public static final int THEME_AMBER = 13;
    public static final int THEME_ORANGE = 14;
    public static final int THEME_DEEPORANGE = 15;
    public static final int THEME_BROWN = 16;
    public static final int THEME_GRAY = 17;
    public static final int THEME_BLUEGRAY = 18;
    public static final int THEME_GREEN_DARK = 19;

     public static final int MODE_NIGHT_NO = 1;
    public static final int MODE_NIGHT_YES = 2;
    public static final int MODE_NIGHT_AUTO = 0;
    // Modos possíveis:
// - MODE_NIGHT_NO (claro)
// - MODE_NIGHT_YES (escuro)
// - MODE_NIGHT_FOLLOW_SYSTEM (segue o sistema)
// - MODE_NIGHT_AUTO_BATTERY (automático + economia de bateria)
/*    public static void setMode(Context ctx, boolean ModeNight) {

        if(ModeNight){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

      //   SharedPreferences sharedpreferences = PreferenceManager.getDefaultSharedPreferences(ctx);
       SharedPreferences sharedpreferences = ctx.getSharedPreferences(MyPrefTheme, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putBoolean("ModeNight", ModeNight);
        editor.apply();
    }*/

    public static void setMyTheme(Context ctx, int themeid) {
        ctx.setTheme(getThemeId(themeid));
        SharedPreferences sharedpreferences = ctx.getSharedPreferences(MyPrefTheme, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putInt("theme", themeid);
        editor.apply();

    }

/*    public void setModeTheme(Context ctx, int ModeNight, int themeid) {

        ctx.setTheme(getThemeId(themeid));
        AppCompatDelegate.setDefaultNightMode(ModeNight);
        SharedPreferences sharedpreferences = ctx.getSharedPreferences(MyPrefTheme, Context.MODE_PRIVATE);

        SharedPreferences.Editor theme = sharedpreferences.edit();
        theme.putInt("theme", themeid);
        theme.apply();


        SharedPreferences.Editor mode = sharedpreferences.edit();
        mode.putInt("ModeNight", ModeNight);
        mode.apply();

    }*/

    public List<Theme> getListTheme() {
        return ThemeUtil.getThemeList();
    }

    public static int getThemeId(int theme){
        int themeId=0;
        switch (theme){
            case THEME_RED  :
                themeId = R.style.AppTheme_RED;
                break;
            case THEME_PINK  :
                themeId = R.style.AppTheme_PINK;
                break;
            case THEME_PURPLE  :
                themeId = R.style.AppTheme_PURPLE;
                break;
            case THEME_DEEPPURPLE  :
                themeId = R.style.AppTheme_DEEPPURPLE;
                break;
            case THEME_INDIGO  :
                themeId = R.style.AppTheme_INDIGO;
                break;
            case THEME_BLUE  :
                themeId = R.style.AppTheme_BLUE;
                break;
            case THEME_LIGHTBLUE  :
                themeId = R.style.AppTheme_LIGHTBLUE;
                break;
            case THEME_CYAN  :
                themeId = R.style.AppTheme_CYAN;
                break;
            case THEME_TEAL  :
                themeId = R.style.AppTheme_TEAL;
                break;
            case THEME_GREEN  :
                themeId = R.style.AppTheme_GREEN;
                break;
            case THEME_LIGHTGREEN  :
                themeId = R.style.AppTheme_LIGHTGREEN;
                break;
            case THEME_LIME  :
                themeId = R.style.AppTheme_LIME;
                break;
            case THEME_YELLOW  :
                themeId = R.style.AppTheme_YELLOW;
                break;
            case THEME_AMBER  :
                themeId = R.style.AppTheme_AMBER;
                break;
            case THEME_ORANGE  :
                themeId = R.style.AppTheme_ORANGE;
                break;
            case THEME_DEEPORANGE  :
                themeId = R.style.AppTheme_DEEPORANGE;
                break;
            case THEME_BROWN  :
                themeId = R.style.AppTheme_BROWN;
                break;
            case THEME_GRAY  :
                themeId = R.style.AppTheme_GRAY;
                break;
            case THEME_BLUEGRAY  :
                themeId = R.style.AppTheme_BLUEGRAY;
                break;
            case THEME_GREEN_DARK  :
                themeId = R.style.AppTheme_GREEN_DARK;
                break;
            default:
                break;
        }
        return themeId;
    }
    
    public static ArrayList<Theme> getThemeList(){
        ArrayList<Theme> themeArrayList = new ArrayList<>();
        themeArrayList.add(new Theme(0,R.color.primaryColorRed, R.color.primaryDarkColorRed, R.color.secondaryColorRed));
        themeArrayList.add(new Theme(1,R.color.primaryColorPink, R.color.primaryDarkColorPink, R.color.secondaryColorPink));
        themeArrayList.add(new Theme(2,R.color.primaryColorPurple, R.color.primaryDarkColorPurple, R.color.secondaryColorPurple));
        themeArrayList.add(new Theme(3,R.color.primaryColorDeepPurple, R.color.primaryDarkColorDeepPurple, R.color.secondaryColorDeepPurple));
        themeArrayList.add(new Theme(4,R.color.primaryColorIndigo, R.color.primaryDarkColorIndigo, R.color.secondaryColorIndigo));
        themeArrayList.add(new Theme(5,R.color.primaryColorBlue, R.color.primaryDarkColorBlue, R.color.secondaryColorBlue));
        themeArrayList.add(new Theme(6,R.color.primaryColorLightBlue, R.color.primaryDarkColorLightBlue, R.color.secondaryColorLightBlue));
        themeArrayList.add(new Theme(7,R.color.primaryColorCyan, R.color.primaryDarkColorCyan, R.color.secondaryColorCyan));
        themeArrayList.add(new Theme(8,R.color.primaryColorTeal, R.color.primaryDarkColorTeal, R.color.secondaryColorTeal));
        themeArrayList.add(new Theme(9,R.color.primaryColorGreen, R.color.primaryDarkColorGreen, R.color.secondaryColorGreen));
        themeArrayList.add(new Theme(10,R.color.primaryColorLightGreen, R.color.primaryDarkColorLightGreen, R.color.secondaryColorLightGreen));
        themeArrayList.add(new Theme(11,R.color.primaryColorLime, R.color.primaryDarkColorLime, R.color.secondaryColorLime));
        themeArrayList.add(new Theme(12,R.color.primaryColorYellow, R.color.primaryDarkColorYellow, R.color.secondaryColorYellow));
        themeArrayList.add(new Theme(13,R.color.primaryColorAmber, R.color.primaryDarkColorAmber, R.color.secondaryColorAmber));
        themeArrayList.add(new Theme(14,R.color.primaryColorOrange, R.color.primaryDarkColorOrange, R.color.secondaryColorOrange));
        themeArrayList.add(new Theme(15,R.color.primaryColorDeepOrange, R.color.primaryDarkColorDeepOrange, R.color.secondaryColorDeepOrange));
        themeArrayList.add(new Theme(16,R.color.primaryColorBrown, R.color.primaryDarkColorBrown, R.color.secondaryColorBrown));
        themeArrayList.add(new Theme(17,R.color.primaryColorGray, R.color.primaryDarkColorGray, R.color.secondaryColorGray));
        themeArrayList.add(new Theme(18,R.color.primaryColorBlueGray, R.color.primaryDarkColorBlueGray, R.color.secondaryColorBlueGray));
        themeArrayList.add(new Theme(19,R.color.primaryColorGreenDark, R.color.primaryDarkColorGreenDark, R.color.secondaryColorGreenDark));
        return themeArrayList;
    }


    public static int getThemeFromPreferences(Context ctx) {

        SharedPreferences sharedpreferences = ctx.getSharedPreferences(MyPrefTheme, Context.MODE_PRIVATE);
        return sharedpreferences.getInt("theme", 0);

    }

    public static boolean getModeNightFromPreferences(Context ctx) {

        SharedPreferences sharedpreferences = ctx.getSharedPreferences(MyPrefTheme, Context.MODE_PRIVATE);
        return sharedpreferences.getBoolean("ModeNight", false);



    }

}
