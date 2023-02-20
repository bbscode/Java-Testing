package src;

import java.io.Serializable;

public class Message implements Serializable{
    private String text;

    public Message(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public static Message sendMessage(String text){
        return new Message(text);
    }
    
}
