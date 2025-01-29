/**
 * This class defines the proogram's built in messaging feature
 * this allows on site and direct initial communication between the donors and organisations
 * By allowing for preliminary communications,donors and organisations can establish rapport before proceeding to exchange
 * required information which ensures safety for all users
 */
public class Message {
    private User sender;
    private User receiver;
    private String text;

    public Message(User sender,User receiver,String text){
        this.sender=sender;
        this.receiver=receiver;
        this.text=text;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
