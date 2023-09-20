package com.msm.themes.util;

import android.content.Context;
import android.content.SharedPreferences;

public class themePreferencia {


	public static String getVersionPlayStore(Context paramContext) {
		return paramContext.getSharedPreferences("preferencias", 0).getString("versionPlayStore", null);
	}

	public static void setVersionPlayStore(Context paramContext, String paramString) {
		SharedPreferences.Editor editor = paramContext.getSharedPreferences("preferencias", 0).edit();
		editor.putString("versionPlayStore", paramString);
		editor.apply();
	}

	public static String getDateUpdate(Context paramContext) {
		return paramContext.getSharedPreferences("preferencias", 0).getString("dateUpdate", "");
	}

	public static void setDateUpdate(Context paramContext, String paramString) {
		SharedPreferences.Editor editor = paramContext.getSharedPreferences("preferencias", 0).edit();
		editor.putString("dateUpdate", paramString);
		editor.apply();
	}

	public static String getNews(Context paramContext) {
		return paramContext.getSharedPreferences("preferencias", 0).getString("news", "");
	}

	public static void setNews(Context paramContext, String paramString) {
		SharedPreferences.Editor editor = paramContext.getSharedPreferences("preferencias", 0).edit();
		editor.putString("news", paramString);
		editor.apply();
	}


	public static String getProvider(Context paramContext) {
		return paramContext.getSharedPreferences("preferencias", 0).getString("Provider", "");
	}

	public static void setProvider(Context paramContext, String paramString) {
		SharedPreferences.Editor editor = paramContext.getSharedPreferences("preferencias", 0).edit();
		editor.putString("Provider", paramString);
		editor.apply();
	}


}
