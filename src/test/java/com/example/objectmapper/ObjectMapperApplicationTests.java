package com.example.objectmapper;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class ObjectMapperApplicationTests {

    @Test
    void contextLoads() throws IOException {
        System.out.println("------");
        // Text Json -> Object
        // Object -> Text JSON

        // controller req json(text) -> object
        // response object -> json(text)

        System.out.println("------");

        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User("steve", 10);

        String text = objectMapper.writeValueAsString(user);
        System.out.println("text :" + text);

        // text -> object
        // object mapper는 default 생성자를 필요로 한다.
        User objectUser = objectMapper.readValue(text, User.class);
        System.out.println("objectUser: "+ objectUser);

    }

}
