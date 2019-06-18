package circles.circles.com.circles.Presenter;

import android.widget.TextView;

import circles.circles.com.circles.mvp.ActPresenter;
import circles.circles.com.circles.mvp.GEMUI;
import circles.circles.com.circles.mvp.MVPActivity;

public class MainPresenter extends ActPresenter<MainPresenter.MainUI> {
    public interface MainUI extends GEMUI {
        TextView gettvmvp();
        void setinfo(String userinfo);

    }

    @Override
    public void onUIReady(MVPActivity activity, MainUI ui) {
        super.onUIReady(activity, ui);
        //这里可以做p层一些初始化   如网络请求
        getdatainfo();
    }

    public void tvedit() {
        getUI().gettvmvp().setText("改变后的文字");
    }


    public void  getdatainfo(){
         //模拟进行网络请求  得到数据
          String userinfo="网络请求得到的数据";
          //将userinfo交给view层进行页面的更新操作
          getUI().setinfo(userinfo);


    }



}
