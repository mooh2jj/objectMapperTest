package com.example.objectmapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("------");
        // Text Json -> Object
        // Object -> Text JSON

        // controller req json(text) -> object
        // response object -> json(text)

        Object objectMapper = new ObjectMapper();

        User user = new User("steve", 10);

        String text = objectMapper.


    }

}
