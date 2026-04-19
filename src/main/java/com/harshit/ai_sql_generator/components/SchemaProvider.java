package com.harshit.ai_sql_generator.components;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class SchemaProvider {
    public String getSchema(){
        try {
            InputStream inputStream = getClass()
                    .getClassLoader()
                    .getResourceAsStream("schema.txt");

            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load schema", e);
        }
    }
}
