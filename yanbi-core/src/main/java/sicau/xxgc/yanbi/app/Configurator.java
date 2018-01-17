package sicau.xxgc.yanbi.app;

import java.util.WeakHashMap;

/**
 * Created by yanbi on 2018/1/16.
 */

public class Configurator {

    private static final WeakHashMap<String,Object> YANBI_CONFIGS=new WeakHashMap<>();

    private Configurator(){
        YANBI_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }
    public final void configure(){
        YANBI_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }
    final WeakHashMap<String,Object> getYanbiConfigs(){
        return YANBI_CONFIGS;
    }
    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }
    private static class Holder{
        private static final Configurator INSTANCE=new Configurator();
    }
    public final Configurator withApiHost(String host){
        YANBI_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }
    private void checkConfiguration(){
        final boolean isReady= (boolean) YANBI_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }
    final <T> T getConfiguration(Enum<ConfigType> key){
        checkConfiguration();
        return (T) YANBI_CONFIGS.get(key);
    }
}
