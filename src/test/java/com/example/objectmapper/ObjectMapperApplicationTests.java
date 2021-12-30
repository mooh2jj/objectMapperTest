package com.example.objectmapper;


import com.example.objectmapper.dto.User;
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

        // controller req json(text) ->자동적으로 object
        // response object -> 자동적으로 json(text)

        // 스프링에서는 ObjectMapper를 많이 사용한다!
        System.out.println("------");

        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User("steve", 10);

        String text = objectMapper.writeValueAsString(user);
        System.out.println("text :" + text);

        // text -> object
        // object mapper는 default 생성자를 필요로 한다.
        User objectUser = objectMapper.readValue(text, User.class);
        System.out.println("objectUser: " + objectUser);


    }

}
