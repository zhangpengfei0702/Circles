package circles.circles.com.circles.mvp;



public interface IPresenter<V extends GEMUI> {
    MVPActivity getActivity();

    V getUI();

    String getString(int resId);

    void onUIReady(MVPActivity activity, V ui);
}
