package circles.circles.com.circles.Presenter;

import android.widget.TextView;

import circles.circles.com.circles.mvp.ActPresenter;
import circles.circles.com.circles.mvp.GEMUI;
import circles.circles.com.circles.mvp.MVPActivity;

public class MainPresenter extends ActPresenter<MainPresenter.MainUI> {
    public interface MainUI extends GEMUI {
        TextView gettvmvp();
    }

    @Override
    public void onUIReady(MVPActivity activity, MainUI ui) {
        super.onUIReady(activity, ui);
        //这里可以做p层一些初始化   如网络请求
    }

    public void tvedit() {
        getUI().gettvmvp().setText("改变后的文字");
    }

}
