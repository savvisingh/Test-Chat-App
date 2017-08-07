package apps.savvisingh.docsapptestapp.data.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by SavviSingh on 07/08/17.
 */
@Entity
public class Message {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "message_text")
    public String text;

    @ColumnInfo(name = "created_at")
    public String createdAt;

    @ColumnInfo(name = "user_type")
    public String userType;

    public Message(String text, String createdAt, String userType){
        this.text = text;
        this.createdAt = createdAt;
        this.userType = userType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
