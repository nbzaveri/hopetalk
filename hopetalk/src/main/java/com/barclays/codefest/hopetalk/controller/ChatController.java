package com.barclays.codefest.hopetalk.controller;

import com.barclays.codefest.hopetalk.controller.service.ChatService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@NoArgsConstructor
public class ChatController {

    @Autowired
    private ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @RequestMapping("/chats/test")
    public String testMessage() {
        return "Hello World!";
    }
    //@RequestMapping(method = RequestMethod.GET, value = "/{chatId}/{senderId}/sendMessage")
    @GetMapping("/chats/talk/{chatId}/{senderId}/{message}")
    public void sendMessage(@PathVariable("chatId") int chatId, @PathVariable("senderId") int senderId,
                            @PathVariable("message") String message){
        chatService.sendMessage(chatId, senderId, message);
    }

    //@RequestMapping(method = RequestMethod.GET, value = "/startChat/{therapistId}/{clientId}")
    @GetMapping("/chats/startChat/{therapistId}/{clientId}")
    public int startChat(@PathVariable("therapistId") int therapistId, @PathVariable("clientId") int clientId) {
        return chatService.startChat(therapistId, clientId);
    }

    //@RequestMapping(method = RequestMethod.GET, value = "/{chatId}/endChat")
    @GetMapping("/chats/{chatId}/endChat")
    public void endChat(@PathVariable("chatId") int chatId) {
        chatService.endChat(chatId);
    }
}
