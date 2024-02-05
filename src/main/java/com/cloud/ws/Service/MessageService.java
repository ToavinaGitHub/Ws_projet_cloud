package com.cloud.ws.Service;

import com.cloud.ws.Model.Message;
import com.cloud.ws.Model.Utilisateur;
import com.cloud.ws.Repository.MessageRepository;
import com.cloud.ws.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UtilisateurRepository utilisateurRepository;

    public void save(Message s){
        s.setDateMessage(LocalDateTime.now());
        messageRepository.save(s);
    }

    public List<Message> getMessageEntre(int user1,int user2){

        List<Message> messages = messageRepository.getAllDiscussionsBetween(user1, user2);
        messages.sort(Comparator.comparing(Message::getDateMessage));

        return messages;
    }

    public List<Utilisateur> getUsersInConversations(int userId) {
        List<Message> messages = messageRepository.getConversationsForUser(userId);

        Set<Utilisateur> userIds = new HashSet<>();

        for (Message message : messages) {
            if (message.getIdSender() != userId) {

                Utilisateur temp = utilisateurRepository.findUtilisateurByIdUtilisateur(message.getIdSender());

                userIds.add(temp);
            }
            if (message.getIdReceiver() != userId) {
                Utilisateur temp = utilisateurRepository.findUtilisateurByIdUtilisateur(message.getIdReceiver());

                userIds.add(temp);
            }
        }

        return new ArrayList<>(userIds);
    }

    public List<Utilisateur> getUsersWithLastMessage(int userId) {

        System.out.println("haha");
        List<Message> messages = messageRepository.getConversationsForUser(userId);

        Map<Utilisateur, Message> lastMessages = new HashMap<>();

        for (Message message : messages) {
            Utilisateur otherUser = null;
            Message lastMessage = lastMessages.getOrDefault(otherUser, null);

            if (message.getIdSender() != userId) {
                otherUser = utilisateurRepository.findUtilisateurByIdUtilisateur(message.getIdSender());
            } else if (message.getIdReceiver() != userId) {
                otherUser = utilisateurRepository.findUtilisateurByIdUtilisateur(message.getIdReceiver());
            }

            if (otherUser != null) {
                if (lastMessage == null || message.getDateMessage().compareTo(lastMessage.getDateMessage()) > 0) {
                    lastMessages.put(otherUser, message);
                }
            }
        }

        return new ArrayList<>(lastMessages.keySet());
    }

}
