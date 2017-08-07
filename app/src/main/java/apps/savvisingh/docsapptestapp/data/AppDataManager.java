package apps.savvisingh.docsapptestapp.data;

import android.content.Context;

import java.util.List;

import apps.savvisingh.docsapptestapp.data.db.DataBaseClient;
import apps.savvisingh.docsapptestapp.data.db.Message;
import apps.savvisingh.docsapptestapp.data.db.MessageDataBase;
import apps.savvisingh.docsapptestapp.data.network.ChatAPIService;
import apps.savvisingh.docsapptestapp.data.network.NetworkClient;
import apps.savvisingh.docsapptestapp.data.network.model.ChatApiResponse;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.internal.operators.completable.CompletableFromAction;

/**
 * Created by SavviSingh on 06/08/17.
 */

public class AppDataManager implements DataManager{

    ChatAPIService chatAPIService;
    MessageDataBase db;

    public AppDataManager(Context context){
        chatAPIService = new ChatAPIService(NetworkClient.getClient());
        db = DataBaseClient.getClient(context);

    }

    @Override
    public Observable<ChatApiResponse> sendMessage(String message) {
        return chatAPIService.sendMessage(message);
    }

    @Override
    public Single<List<Message>> getChatHistory() {
        return db.messageDao().fetchMessageHistory();
    }

    @Override
    public Completable insertMessage(Message message) {
        return new CompletableFromAction(() -> db.messageDao().insertRecord(message));
    }


}
