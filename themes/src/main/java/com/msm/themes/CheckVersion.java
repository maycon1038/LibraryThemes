package com.msm.themes;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.util.Log;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.msm.themes.interfaces.CheckVersionApp;
import com.msm.themes.interfaces.Translation;
import com.msm.themes.util.Tradutor;
import com.msm.themes.util.Util;

import org.jsoup.Jsoup;

import java.nio.charset.Charset;

import static com.msm.themes.util.Util.isOnline;

public class CheckVersion {

    private Context ctx;
    private PackageInfo infor;


    public CheckVersion(Context ctx, PackageInfo infor) {
        this.ctx = ctx;
        this.infor = infor;
    }

    public void getVersionPlayStore(final CheckVersionApp check) {


        if(isOnline()){
            Ion.with(ctx).load(ctx.getString(R.string.linkPlayStore, infor.packageName))
                    .asString(Charset.forName("utf-8")).setCallback(new FutureCallback<String>() {
                @Override
                public void onCompleted(Exception e, String result) {

                    if (result != null) {
                        try {
                            final    String news = Jsoup.parse(result).select("div.PHBdkd:nth-child(2) > div.DWPxHb:nth-child(1)  > span:nth-child(1)")
                                    .first().ownText();// + " ok";

                          final  String newVersionPlayStore = Jsoup.parse(result).select("div.hAyfc:nth-child(4) > span:nth-child(2) > div:nth-child(1) > span:nth-child(1)")
                                    .first()
                                    .ownText();

                            final    String dateUpdate = Jsoup.parse(result).select("div.hAyfc:nth-child(1) > span:nth-child(2) > div:nth-child(1) > span:nth-child(1)")
                                    .first()
                                    .ownText();

                            new Tradutor(ctx, dateUpdate)
                                    .setCallback(new Translation() {
                                @Override
                                public void textTranslation(String text) {

                                    if(text != null){
                                        check.newVersionApp(newVersionPlayStore,text,news,null);
                                    }else{
                                        check.newVersionApp(newVersionPlayStore,dateUpdate,news,null);
                                    }
                                }
                            });


                            check.newVersionApp(newVersionPlayStore,dateUpdate,news,null);
                        } catch (Exception el) {
                            check.newVersionApp(null,null,null,el.getMessage());
                        }
                    }else{
                        check.newVersionApp(null,null,null,e.getMessage());
                    }

                }
            });


        }else{
            check.newVersionApp(null,null,null,"Sem conexão");
        }



    }
}
