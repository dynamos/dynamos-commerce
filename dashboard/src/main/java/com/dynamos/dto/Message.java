package com.dynamos.dto;

/**
 * Created by adelmo on 07/02/16.
 */
public class Message {

    private String messageType;

    private String title;

    private String body;

    public Message(){}

    public Message(String title, String body, MessageType messageType){
        this.title = title;
        this.body = body;
        this.messageType = messageType.getType();
    }


    public String getMessageType() {
        return messageType;
    }

    public void setMessageType(String messageType) {
        this.messageType = messageType;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
