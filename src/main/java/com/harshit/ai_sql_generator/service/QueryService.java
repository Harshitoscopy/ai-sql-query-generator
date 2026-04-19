package com.harshit.ai_sql_generator.service;


import com.harshit.ai_sql_generator.components.SchemaProvider;
import org.springframework.ai.chat.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class QueryService {
    private ChatClient chatClient;
    private SchemaProvider schemaProvider;
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public QueryService(ChatClient chatClient, SchemaProvider schemaProvider, JdbcTemplate jdbcTemplate) {
        this.chatClient = chatClient;
        this.schemaProvider = schemaProvider;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> processQuery(String query){
        String prompt = "Convert the following natural language query into an Oracle SQL query. " + "Please find schema context: " +
                schemaProvider.getSchema() +
                "Return ONLY the SQL query, no explanation no markdown either .\n\n" +
                "User Query: " + query;
        String sql = chatClient.call(prompt);
        return jdbcTemplate.queryForList(sql);
    }
}
