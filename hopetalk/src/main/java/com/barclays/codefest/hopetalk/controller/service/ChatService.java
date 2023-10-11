package com.barclays.codefest.hopetalk.controller.service;

import com.barclays.codefest.hopetalk.HopetalkApplication;
import com.barclays.codefest.hopetalk.repository.ChatRepository;
import com.barclays.codefest.hopetalk.repository.model.ChatSession;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.time.Instant;

@Service
public class ChatService {
    private ChatRepository chatRepository;

    public ChatService(ChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    public void sendMessage(int chatId, int senderId, String message) {
        ChatSession chatSession = chatRepository.findById(chatId)
                .orElseThrow(() -> new ResourceNotFoundException("Chat is not found for this id :: " + chatId));
        ChatSession anotherChat = new ChatSession();
        anotherChat.setChatId(chatSession.getChatId());
        anotherChat.setTherapistId(chatSession.getTherapistId());
        anotherChat.setClientId(chatSession.getClientId());
        Instant instant = Instant.now();
        Timestamp timestamp = Timestamp.from(instant);
        anotherChat.setStartTime(timestamp);
        anotherChat.setSenderId(senderId);
        anotherChat.setMessage(message);
        chatRepository.save(chatSession);
    }

    public int startChat(int therapistId, int clientId) {
        ChatSession chatSession = new ChatSession();
        chatSession.setTherapistId(therapistId);
        chatSession.setClientId(clientId);
        Instant instant = Instant.now();
        Timestamp timestamp = Timestamp.from(instant);
        chatSession.setStartTime(timestamp);
        chatSession.setMessage("Chat Session Started between Therapist {} and Client {}");
        chatRepository.save(chatSession);
        return chatSession.getChatId();
    }

    public void endChat(int chatId) {
        //this.delete(chatId);
    }
}
