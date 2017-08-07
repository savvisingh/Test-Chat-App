package apps.savvisingh.docsapptestapp.ui.main;

import java.util.List;

import apps.savvisingh.docsapptestapp.data.db.Message;
import apps.savvisingh.docsapptestapp.ui.base.MvpView;

/**
 * Created by SavviSingh on 06/08/17.
 */

public interface MainMvpView  extends MvpView{

    public void displayMessage(Message message);

    public void loadChatHistory(List<Message> mList);
}
