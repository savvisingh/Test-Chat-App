package apps.savvisingh.docsapptestapp.data;

import java.util.List;

import apps.savvisingh.docsapptestapp.data.db.Message;
import apps.savvisingh.docsapptestapp.data.network.model.ChatApiResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by SavviSingh on 06/08/17.
 */

public interface DataManager {

    Observable<ChatApiResponse> sendMessage(String message);

    Single<List<Message>> getChatHistory();

    Completable insertMessage(Message message);

}
