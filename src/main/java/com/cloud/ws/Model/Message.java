package com.cloud.ws.Model;

import jakarta.persistence.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Document(collection = "message")
public class Message {

    @Id
    private int idMessage;

    private String message;

    private LocalDateTime dateMessage;
    private int etat;

    private int idSender;

    private int idReceiver;

    public Message(int idMessage, String message, LocalDateTime dateMessage, int etat, int idSender, int idReceiver) {
        this.idMessage = idMessage;
        this.message = message;
        this.dateMessage = dateMessage;
        this.etat = etat;
        this.idSender = idSender;
        this.idReceiver = idReceiver;
    }

    public Message() {
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(LocalDateTime dateMessage) {
        this.dateMessage = dateMessage;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getIdSender() {
        return idSender;
    }

    public void setIdSender(int idSender) {
        this.idSender = idSender;
    }

    public int getIdReceiver() {
        return idReceiver;
    }

    public void setIdReceiver(int idReceiver) {
        this.idReceiver = idReceiver;
    }
}