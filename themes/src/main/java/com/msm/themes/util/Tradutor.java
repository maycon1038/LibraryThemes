package com.msm.themes.util;

import android.content.Context;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.common.model.DownloadConditions;
import com.google.mlkit.nl.translate.TranslateLanguage;
import com.google.mlkit.nl.translate.Translation;
import com.google.mlkit.nl.translate.Translator;
import com.google.mlkit.nl.translate.TranslatorOptions;
import com.msm.themes.interfaces.iTranslation;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;


public class Tradutor {

    Context ctx;
    String texto;
	Translator  portuguesTranslator;

    public Tradutor(Context ctx, String texto) {
        this.ctx = ctx;
        this.texto = texto;

            TranslatorOptions options = new TranslatorOptions.Builder()
                .setSourceLanguage(TranslateLanguage.ENGLISH)
                .setTargetLanguage(TranslateLanguage.PORTUGUESE)
                .build();
        portuguesTranslator =  Translation.getClient(options);

        DownloadConditions conditions = new DownloadConditions.Builder()
                .requireWifi()
                .build();
        portuguesTranslator.downloadModelIfNeeded(conditions);

    }

	public void setCallback(final iTranslation callback) {

		try {
			final String query = URLEncoder.encode(texto, "UTF-8");
			portuguesTranslator.translate(query)
					.addOnSuccessListener(new OnSuccessListener<String>() {
						@Override
						public void onSuccess(String s) {
							portuguesTranslator.close();
							callback.textTranslation(s);
						}
					})
					.addOnFailureListener(
							new OnFailureListener() {
								@Override
								public void onFailure(@NonNull Exception e) {
									portuguesTranslator.close();
									callback.textTranslation(query);
								}
							});
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}



	}

}
