package sicau.xxgc.yanbi.app;

import android.content.Context;
import android.os.Handler;

import java.util.WeakHashMap;

/**
 * Created by yanbi on 2018/1/16.
 */

public final class Yanbi{

    public static Configurator init(Context context){
        getConfigurations().put(ConfigKeys.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }
    //获得配置
    public static WeakHashMap<Object,Object> getConfigurations(){
        return Configurator.getInstance().getYanbiConfigs();
    }

    public static Configurator getConfigurator(){
        return Configurator.getInstance();
    }

    public static <T> T getConfiguration(Object key){
        return getConfigurator().getConfiguration(key);
    }

    public static Context getApplicationContext(){
        return getConfiguration(ConfigType.APPLICATION_CONTEXT.name());
    }

    public static Handler getHandler(){
        return getConfiguration(ConfigKeys.HANDLER);
    }

}
