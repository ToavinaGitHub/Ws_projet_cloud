package com.cloud.ws.Controller;

import com.cloud.ws.Model.Message;
import com.cloud.ws.Model.Utilisateur;
import com.cloud.ws.Service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/sendMessage")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity save(@RequestBody Message m){
        messageService.save(m);

        return ResponseEntity.ok("Message sent avec succes");
    }

    @GetMapping("/messageBetween")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Message> getDiscu(@RequestParam int user1 ,@RequestParam int user2){

        List<Message> all = messageService.getMessageEntre(user1,user2);

        return all;

    }

    @GetMapping("/boiteDiscu")
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public List<Utilisateur> boiteDiscu(@RequestParam int user){
        return messageService.getUsersInConversations(user);
    }

}
