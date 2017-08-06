package apps.savvisingh.docsapptestapp.ui.main;

/**
 * Created by SavviSingh on 06/08/17.
 */

public class Message {

    private String message, createdAt;
    private String userType;

    public Message(){}

    public Message(String message, String createdAt, String userType){
        this.message = message;
        this.createdAt = createdAt;
        this.userType = userType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
