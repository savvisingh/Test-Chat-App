package apps.savvisingh.docsapptestapp.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by SavviSingh on 07/08/17.
 */

@Database(entities = {Message.class}, version = 1)
public abstract class MessageDataBase extends RoomDatabase{
    public abstract MessageDao messageDao();
}
