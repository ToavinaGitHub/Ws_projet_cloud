package com.cloud.ws.Model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "Message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMessage;

    @Column(name = "message", columnDefinition = "TEXT")
    private String message;

    @Column(name = "dateMessage")
    private Timestamp dateMessage;

    @Column(name = "etat")
    private int etat;

    @ManyToOne
    @JoinColumn(name = "sender", nullable = false)
    private Utilisateur sender;

    @ManyToOne
    @JoinColumn(name = "receiver", nullable = false)
    private Utilisateur receiver;

    public Message(int idMessage, String message, Timestamp dateMessage, int etat, Utilisateur sender, Utilisateur receiver) {
        this.idMessage = idMessage;
        this.message = message;
        this.dateMessage = dateMessage;
        this.etat = etat;
        this.sender = sender;
        this.receiver = receiver;
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

    public Timestamp getDateMessage() {
        return dateMessage;
    }

    public void setDateMessage(Timestamp dateMessage) {
        this.dateMessage = dateMessage;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Utilisateur getSender() {
        return sender;
    }

    public void setSender(Utilisateur sender) {
        this.sender = sender;
    }

    public Utilisateur getReceiver() {
        return receiver;
    }

    public void setReceiver(Utilisateur receiver) {
        this.receiver = receiver;
    }
}
