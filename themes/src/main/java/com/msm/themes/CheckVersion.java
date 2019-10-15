package com.msm.themes;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.util.Log;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.jsoup.Jsoup;

import java.nio.charset.Charset;

public class CheckVersion {

    public static void checkVersion(final Context ctx, final String app_name, final PackageInfo infor) {

        final String msm = ctx.getResources().getString(R.string.atualizarApp, app_name);
        Ion.with(ctx).load(ctx.getString(R.string.linkPlayStore, infor.packageName))
                .asString(Charset.forName("utf-8")).setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {

                if (result != null) {
                    try {
                        String news = Jsoup.parse(result).select("div.PHBdkd:nth-child(2) > div.DWPxHb:nth-child(1)  > content")
                                .first().ownText();// + " ok";
                        String myVersionPlayStore = Jsoup.parse(result).select("div.hAyfc:nth-child(4) > span:nth-child(2) > div:nth-child(1) > span:nth-child(1)")
                                .first()
                                .ownText();
                        if (!myVersionPlayStore.equals(infor.versionName)) {
                            new MaterialDialog.Builder(ctx)
                                    .title(app_name)
                                    .content(msm)
                                    .negativeText(R.string.btn_nao)
                                    .positiveText(R.string.btn_sim)
                                    .onPositive(new MaterialDialog.SingleButtonCallback() {
                                        @Override
                                        public void onClick(MaterialDialog dialog, DialogAction which) {
                                            Uri uri = Uri.parse(ctx.getString(R.string.linkPlayStore,infor.packageName));
                                            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                            ctx.startActivity(intent);

                                        }
                                    }).build().show();
                        }
                        Log.d("CheckVersion", " myVersion " + infor.versionName + " versionLoja "
                                + myVersionPlayStore + "\n packageName: " + infor.packageName
                                + "\n msm: " + msm);
                    } catch (Exception el) {
                        Log.d("CheckVersion", " myVersion " + infor.versionName + " versionLoja "
                                + el.getMessage() + "\n packageName: " + infor.packageName
                                + "\n msm: " + msm);
                    }
                }

            }
        });


    }
}
