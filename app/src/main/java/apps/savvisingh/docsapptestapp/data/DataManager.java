package apps.savvisingh.docsapptestapp.data;

import apps.savvisingh.docsapptestapp.data.network.model.ChatApiResponse;
import io.reactivex.Observable;

/**
 * Created by SavviSingh on 06/08/17.
 */

public interface DataManager {

    Observable<ChatApiResponse> sendMessage(String message);

}
