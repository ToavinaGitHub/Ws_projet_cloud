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

}
