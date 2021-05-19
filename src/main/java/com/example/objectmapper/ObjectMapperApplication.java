package com.example.objectmapper;

import com.example.objectmapper.dto.Car;
import com.example.objectmapper.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
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
        user.setName("dsg22");
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

        String json = objectMapper.writeValueAsString(user);

        System.out.println(json);

        // Node로 접근하기!
        JsonNode jsonNode = objectMapper.readTree(json);
        String _name = jsonNode.get("name").asText();
        int _age = jsonNode.get("age").asInt();

//        List<Car> _list = jsonNode.get("cars").as

        System.out.println("name :" + _name);
        System.out.println("age :" + _age);

        JsonNode cars = jsonNode.get("cars");
        ArrayNode arrayNode = (ArrayNode) cars; // Array 파싱 

        List<Car> _cars = objectMapper.convertValue(arrayNode, new TypeReference<List<Car>>() {});
        System.out.println("_cars :" + _cars);
    }

}
