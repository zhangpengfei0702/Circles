package circles.circles.com.circles.mvp.base;

import android.os.Bundle;

import circles.circles.com.circles.mvp.FragmentPresenter;
import circles.circles.com.circles.mvp.GEMUI;
import circles.circles.com.circles.mvp.MVPFragment;
import circles.circles.com.circles.mvp.ViewFinder;


/**
 * Created by wpy on 2017/7/22.
 */

/**
 * Fragment的base基类
 * @param <V>
 * @param <P>
 */
public abstract class BaseFragment<V extends GEMUI, P extends FragmentPresenter<V>> extends MVPFragment<V, P>
        implements GEMUI {
    private ViewFinder finder;
    private P presenter;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        finder = new ViewFinder(getActivity());
        initViews();
        presenter = createPresenter();
        presenter.onActivityCreated(savedInstanceState);
    }


    protected abstract void initViews();

    public ViewFinder finder() {
        return finder;
    }

    @Override
    public void showProgress(String title, String content) {
        if (getActivity() instanceof BaseActivity)
            ((BaseActivity) getActivity()).showProgress(title, content);
    }

    @Override
    public void dismissProgress() {
        if (getActivity() instanceof BaseActivity)
            ((BaseActivity) getActivity()).dismissProgress();
    }

}