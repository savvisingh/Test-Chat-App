package apps.savvisingh.docsapptestapp.data.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by SavviSingh on 06/08/17.
 */

public class ChatApiResponse {

    @SerializedName("success")
    @Expose
    private int success;
    @SerializedName("errorMessage")
    @Expose
    private String errorMessage;
    @SerializedName("message")
    @Expose
    private Message message;
    @SerializedName("data")
    @Expose
    private List<Object> data = null;

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

}
