package com.msm.themes;

import android.content.Context;
import android.content.pm.PackageInfo;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;
import com.msm.themes.interfaces.CheckVersionApp;

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
                            String news = Jsoup.parse(result).select("div.PHBdkd:nth-child(2) > div.DWPxHb:nth-child(1)  > span:nth-child(1)")
                                    .first().ownText();// + " ok";

                            String newVersionPlayStore = Jsoup.parse(result).select("div.hAyfc:nth-child(4) > span:nth-child(2) > div:nth-child(1) > span:nth-child(1)")
                                    .first()
                                    .ownText();

                            String dateUpdate = Jsoup.parse(result).select("div.hAyfc:nth-child(1) > span:nth-child(2) > div:nth-child(1) > span:nth-child(1)")
                                    .first()
                                    .ownText();
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
