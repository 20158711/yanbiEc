package sicau.xxgc.yanbi.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.WeakHashMap;

import okhttp3.Interceptor;

/**
 * Created by yanbi on 2018/1/16.
 */

public class Configurator {

    private static final WeakHashMap<Object,Object> YANBI_CONFIGS=new WeakHashMap<>();
    private static final ArrayList<IconFontDescriptor> ICONS=new ArrayList<>();
    private static final ArrayList<Interceptor>  INTERCEPTORS=new ArrayList<>();

    //私有化构造方法
    private Configurator(){
        YANBI_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }
    //配置完成
    public final void configure(){
        YANBI_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }
    //返回配置map
    final WeakHashMap<Object,Object> getYanbiConfigs(){
        return YANBI_CONFIGS;
    }
    //获得单例实例
    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }
    //内部类实现单例
    private static class Holder{
        private static final Configurator INSTANCE=new Configurator();
    }
    //添加host
    public final Configurator withApiHost(String host){
        YANBI_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }
    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcon(IconFontDescriptor descriptor) {
        ICONS.add(descriptor);
        return this;
    }
    public final Configurator withInterceptor(Interceptor interceptor) {
        INTERCEPTORS.add(interceptor);
        YANBI_CONFIGS.put(ConfigKeys.INTERCEPTOR, interceptor);
        return this;
    }
    public final Configurator withInterceptors(ArrayList<Interceptor> interceptors) {
        INTERCEPTORS.addAll(interceptors);
        YANBI_CONFIGS.put(ConfigKeys.INTERCEPTOR, interceptors);
        return this;
    }
    //检查配置是否完成
    private void checkConfiguration(){
        final boolean isReady= (boolean) YANBI_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }
    final <T> T getConfiguration(Object key){
        checkConfiguration();
        final Object value=YANBI_CONFIGS.get(key);
        if (value == null) {
            throw new NullPointerException(key.toString()+"IS NULL");
        }
        return (T) YANBI_CONFIGS.get(key);
    }
}
