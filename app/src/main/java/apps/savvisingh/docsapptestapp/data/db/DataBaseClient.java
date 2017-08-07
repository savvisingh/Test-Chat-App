package apps.savvisingh.docsapptestapp.data.db;

import android.arch.persistence.room.Room;
import android.content.Context;

/**
 * Created by SavviSingh on 07/08/17.
 */

public class DataBaseClient {

    public static MessageDataBase db;

    public static MessageDataBase getClient(Context context){

        synchronized (DataBaseClient.class) {
            if (db == null) {
                db = Room.databaseBuilder(context.getApplicationContext(),
                        MessageDataBase.class, "chat-storage").build();
            }
            return db;
        }
    }
}
