package io.dynamos.dto;

/**
 * Created by adelmo on 07/02/16.
 */
public enum MessageType {

    SUCCESS("success"), INFO("info"), DANGER("danger"), WARNING("warning");

    private String value;

    MessageType(String value){
        this.value= value;
    }

    public String getType(){
        return value;
    }
}
