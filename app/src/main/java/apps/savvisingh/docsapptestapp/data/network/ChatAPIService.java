package apps.savvisingh.docsapptestapp.data.network;

import apps.savvisingh.docsapptestapp.data.network.model.ChatApiResponse;
import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * Created by SavviSingh on 06/08/17.
 */

public class ChatAPIService {
    private ChatAPIInterface chatAPIInterface;

    public ChatAPIService(Retrofit retrofit){
        this.chatAPIInterface = retrofit.create(ChatAPIInterface.class);
    }

    public Observable<ChatApiResponse> sendMessage(String message){
        return chatAPIInterface.sendMessage(message);
    }
}
