package apps.savvisingh.docsapptestapp.ui.base;

/**
 * Created by SavviSingh on 06/08/17.
 */

public interface Presenter<T extends MvpView> {

    void onAttach(T mvpView);

    void onDetach();

}
