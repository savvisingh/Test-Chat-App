package apps.savvisingh.docsapptestapp.ui.main;

import apps.savvisingh.docsapptestapp.ui.base.Presenter;

/**
 * Created by SavviSingh on 06/08/17.
 */

public interface MainMvpPresenter<T extends MainMvpView> extends Presenter<T> {

    public void sendMessage(String message);

}
