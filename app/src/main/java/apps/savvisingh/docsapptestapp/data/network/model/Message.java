package apps.savvisingh.docsapptestapp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by SavviSingh on 06/08/17.
 */

public class Message {
    @SerializedName("chatBotName")
    @Expose
    private String chatBotName;
    @SerializedName("chatBotID")
    @Expose
    private int chatBotID;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("emotion")
    @Expose
    private String emotion;

    public String getChatBotName() {
        return chatBotName;
    }

    public void setChatBotName(String chatBotName) {
        this.chatBotName = chatBotName;
    }

    public int getChatBotID() {
        return chatBotID;
    }

    public void setChatBotID(int chatBotID) {
        this.chatBotID = chatBotID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

}
