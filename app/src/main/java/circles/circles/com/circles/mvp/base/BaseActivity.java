package circles.circles.com.circles.mvp.base;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;



import java.util.List;

import circles.circles.com.circles.R;
import circles.circles.com.circles.mvp.ActPresenter;
import circles.circles.com.circles.mvp.GEMUI;
import circles.circles.com.circles.mvp.MVPActivity;
import circles.circles.com.circles.mvp.ViewFinder;


/**
 * Created by wpy on 2017/7/22.
 */

/**
 * Activity的base基类
 *
 * @param <V>
 * @param <P>
 */
public abstract class BaseActivity<V extends GEMUI, P extends ActPresenter<V>> extends MVPActivity<V, P>
        implements GEMUI {
    private ViewFinder finder;




    @Override
    public void hideStatus() {
        if (finder == null)    //此处做判空处理
            finder = new ViewFinder(this);
        if (finder.find(R.id.item_head) != null)
            finder.find(R.id.item_head).setVisibility(View.GONE);
    }

    @Override
    public ViewFinder finder() {
        if (finder == null)
            finder = new ViewFinder(this);

        return finder;
    }

    @Override
    public void showProgress(String title, String content) {
    }

    @Override
    public void dismissProgress() {
    }

    @Override
    protected void onResume() {
        super.onResume();

    }




    /**
     * 递归调用，对所有子Fragement生效
     *
     * @param frag
     * @param requestCode
     * @param resultCode
     * @param data
     */
    private void handleResult(Fragment frag, int requestCode, int resultCode,
                              Intent data) {
        frag.onActivityResult(requestCode & 0xffff, resultCode, data);
        List<Fragment> frags = frag.getChildFragmentManager().getFragments();
        if (frags != null) {
            for (Fragment f : frags) {
                if (f != null)
                    handleResult(f, requestCode, resultCode, data);
            }
        }
    }







}
