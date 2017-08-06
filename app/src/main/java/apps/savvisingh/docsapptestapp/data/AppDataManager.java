package apps.savvisingh.docsapptestapp.data;

import apps.savvisingh.docsapptestapp.data.network.ChatAPIService;
import apps.savvisingh.docsapptestapp.data.network.NetworkClient;
import apps.savvisingh.docsapptestapp.data.network.model.ChatApiResponse;
import io.reactivex.Observable;

/**
 * Created by SavviSingh on 06/08/17.
 */

public class AppDataManager implements DataManager{

    ChatAPIService chatAPIService;

    public AppDataManager(){
        chatAPIService = new ChatAPIService(NetworkClient.getClient());
    }

    @Override
    public Observable<ChatApiResponse> sendMessage(String message) {
        return chatAPIService.sendMessage(message);
    }
}
