package sicau.xxgc.fastec;

import sicau.xxgc.yanbi.activities.ProxyActivity;
import sicau.xxgc.yanbi.delegates.YanbiDelegate;

/**
 * Created by yanbi on 2018/1/17.
 */

public class ExampleActivity extends ProxyActivity {
    @Override
    public YanbiDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
