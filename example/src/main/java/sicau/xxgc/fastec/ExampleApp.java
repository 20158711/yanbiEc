package sicau.xxgc.fastec;

import android.app.Application;

import sicau.xxgc.yanbi.app.Yanbi;

/**
 * Created by yanbi on 2018/1/16.
 */

public class ExampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Yanbi.init(this)
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
