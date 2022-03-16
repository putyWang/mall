package com.ego.commons.ResponseData;

import java.io.Serializable;

public class EasyUiTree implements Serializable {
    private long id;
    private String text;
    private String State;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
