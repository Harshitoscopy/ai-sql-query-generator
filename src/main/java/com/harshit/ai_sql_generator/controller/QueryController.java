package com.harshit.ai_sql_generator.controller;

import com.harshit.ai_sql_generator.DTO.UserQuery;
import com.harshit.ai_sql_generator.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/generator")
public class QueryController {
    @Autowired
    private QueryService queryService;
    @PostMapping("/query")
    public Map<String, String> getQuery(@RequestBody UserQuery userQuery){
        return Map.of("message", queryService.processQuery(userQuery.getQuery()));
    }
}
