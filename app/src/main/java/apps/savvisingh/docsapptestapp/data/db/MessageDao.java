package apps.savvisingh.docsapptestapp.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by SavviSingh on 07/08/17.
 */
@Dao
public interface MessageDao {

    @Insert
    void insertRecord(Message message);

    @Query("SELECT * FROM Message")
    Single<List<Message>> fetchMessageHistory();

    @Delete
    void deleteMessage(Message message);

}
