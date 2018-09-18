package circles.circles.com.circles.mvp;




public interface GEMUI{

    boolean isAlive();

    /**
     * whether is resumed or visible to user
     *
     * @return
     */
    boolean isActive();


    /**
     * Return layout resource for activity or fragment
     *
     * @return
     */
    int getContentLayout();

    /**
     * Provide a viewfinder to simplify find a View in Res
     *
     * @return
     */
    ViewFinder finder();

    void showProgress(String title, String content);

    void dismissProgress();


}
