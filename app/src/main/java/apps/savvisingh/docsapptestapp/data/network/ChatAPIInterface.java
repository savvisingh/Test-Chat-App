package apps.savvisingh.docsapptestapp.data.network;

import apps.savvisingh.docsapptestapp.data.network.model.ChatApiResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by SavviSingh on 06/08/17.
 */

public interface ChatAPIInterface {

    @GET("chat")
    Observable<ChatApiResponse> sendMessage(@Query("message") String message);
}
