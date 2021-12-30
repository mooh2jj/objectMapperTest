package com.example.objectmapper;

import com.example.objectmapper.dto.Car;
import com.example.objectmapper.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ObjectMapperApplication {

    public static void main(String[] args) throws JsonProcessingException {

        SpringApplication.run(ObjectMapperApplication.class, args);
        System.out.println("main##########");

        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
//        user.setName("dsg22");
        user.setAge(15);

        Car car1 = new Car();
        car1.setName("K5");
        car1.setCarNumber("11rk 1111");
        car1.setType("sedan");


        Car car2 = new Car();
        car2.setName("Q5");
        car2.setCarNumber("22rk 2222");
        car2.setType("SUV");

        List<Car> carList = Arrays.asList(car1, car2);
        user.setCars(carList);

        System.out.println(user);

        // 1) object -> json
        String json = objectMapper.writeValueAsString(user);

        System.out.println("json: " + json);

        // 2) JsonNode로 접근하기!
        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();

        System.out.println("name :" + _name);
        System.out.println("age :" + _age);

        JsonNode cars = jsonNode.get("cars");   // String으로 못받음!
        ArrayNode arrayNode = (ArrayNode) cars; // Array 타입으로 파싱

        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {
        });     // List타입으로 convert
        System.out.println("_cars :" + _cars);

        // JsonNode를 쓰는 이유! 이렇게 변경이 가능!
        ObjectNode objectNode = (ObjectNode) jsonNode;
        objectNode.put("name", "steve");
        objectNode.put("age", 24);

        System.out.println("objectNode: " + objectNode.toPrettyString());

    }

}
