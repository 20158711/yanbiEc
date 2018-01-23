package sicau.xxgc.yanbi.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;
import me.yokeyword.fragmentation.SupportActivity;
import sicau.xxgc.yanbi.R;
import sicau.xxgc.yanbi.delegates.YanbiDelegate;

/**
 * Created by yanbi on 2018/1/17.
 */
//此处的SupportActivity是fragmentation中的
public abstract class ProxyActivity extends SupportActivity {

    public abstract YanbiDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    private void initContainer(@Nullable Bundle savedInstanceState){
        final ContentFrameLayout container=new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);
        setContentView(container);
        if (savedInstanceState == null) {
            loadRootFragment(R.id.delegate_container, setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //垃圾回收
        System.gc();
        System.runFinalization();
    }
}
