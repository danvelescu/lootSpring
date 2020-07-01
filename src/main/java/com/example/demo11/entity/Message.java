package com.example.demo11.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "message")
public class Message {
    private long id;
    private String subject;
    private String text;

    public Message(){}

    public Message(long id, String subject, String text) {
        this.id = id;
        this.subject = subject;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String toString() {
        return "Id:[" + this.getId() + "] Subject:[" + this.getSubject() + "] Text:[" + this.getText() + "]";
    }
}
