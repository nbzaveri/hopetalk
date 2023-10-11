package com.barclays.codefest.hopetalk.controller;

import com.barclays.codefest.hopetalk.controller.service.ChatService;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chats")
@NoArgsConstructor
public class ChatController {

    private ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @RequestMapping("/test")
    public String testMessage() {
        return "Hello World!";
    }
    @GetMapping("/{chatId}/{senderId}/sendMessage")
    public void sendMessage(@PathVariable("chatId") int chatId, @PathVariable("senderId") int senderId, String message){
        chatService.sendMessage(chatId, senderId, message);
    }

    @GetMapping("/startChat/{therapistId}/{clientId}")
    public int startChat(@PathVariable("therapistId") int therapistId, @PathVariable("clientId") int clientId) {
        return chatService.startChat(therapistId, clientId);
    }

    @GetMapping("/{chatId}/endChat")
    public void endChat(@PathVariable("chatId") int chatId) {
        chatService.endChat(chatId);
    }
}
