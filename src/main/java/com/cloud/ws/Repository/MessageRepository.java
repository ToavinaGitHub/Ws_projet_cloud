package com.cloud.ws.Repository;

import com.cloud.ws.Model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message,Integer> {


    @Query("{ $or: [ { 'idSender': ?0 }, { 'idReceiver': ?0 } ] }")
    public List<Message> getConversationsForUser(int userId);

        @Query("{ $or: [ { 'idSender': ?0, 'idReceiver': ?1 }, { 'idSender': ?1, 'idReceiver': ?0 } ]  }")
        List<Message> getAllDiscussionsBetween(int user1, int user2);
    }
