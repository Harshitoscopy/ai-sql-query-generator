package com.harshit.ai_sql_generator.service;


import org.springframework.ai.chat.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryService {
    private ChatClient chatClient;
    @Autowired
    public QueryService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }
    public String processQuery(String query){
        return chatClient.call(query);
    }
}
