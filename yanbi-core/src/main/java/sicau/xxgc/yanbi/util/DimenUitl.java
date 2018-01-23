package sicau.xxgc.yanbi.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import sicau.xxgc.yanbi.app.Yanbi;

/**
 * Created by yanbi on 2018/1/17.
 */

public class DimenUitl {

    public static int getScreenWith(){
        final Resources resources= Yanbi.getApplicationContext().getResources();
        final DisplayMetrics dm=resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight(){
        final Resources resources=Yanbi.getApplicationContext().getResources();
        final DisplayMetrics dm=resources.getDisplayMetrics();
        return dm.heightPixels;
    }

}
