package com.msm.themes.util;

import android.util.Log;


public class Tag {

	private String c;
	private Throwable line;
	private String s;


	public Tag(String c) {
		this.c = c;
	}


	public void LogD(String s){

		if(c != null){
			Log.e(c, s);
		}

	}


	public void LogE(String s){

		 if(c != null){
		 	Log.e(c, s);
		 }

	}
	public void LogD(Throwable line, String s){

		if(c != null && line != null && s != null){
			Log.d(c +" "+  line.getStackTrace()[0].getLineNumber(), s);
		}

	}


	public void LogE(Throwable line, String s){

		if(c != null && line != null){
			Log.e(c +" "+  line.getStackTrace()[0].getLineNumber(), s);
		}

	}
}
