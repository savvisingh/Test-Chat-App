package apps.savvisingh.docsapptestapp.ui.main;

import java.util.List;

import apps.savvisingh.docsapptestapp.data.db.Message;
import apps.savvisingh.docsapptestapp.ui.base.Presenter;

/**
 * Created by SavviSingh on 06/08/17.
 */

public interface MainMvpPresenter<T extends MainMvpView> extends Presenter<T> {

    public void sendMessage(String message);

    public void getChatHistory();

}
