package sicau.xxgc.yanbi.app;

import android.content.Context;

import java.util.WeakHashMap;

/**
 * Created by yanbi on 2018/1/16.
 */

public final class Yanbi{

    public static Configurator init(Context context){
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String,Object> getConfigurations(){
        return Configurator.getInstance().getYanbiConfigs();
    }

}
