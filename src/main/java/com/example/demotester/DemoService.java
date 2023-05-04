package com.example.demotester;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


@Service
@Slf4j
public class DemoService {

    public List<RandomUser> getUsers() {
            String apiUrl = "https://random-data-api.com/api/v2/users?size=2";
            RestTemplate restTemplate = new RestTemplate();
        RandomUser[] users = restTemplate.getForObject(apiUrl, RandomUser[].class);
            return Arrays.asList(users);
        }
    public JSONArray getData(){
        log.info("Fetching Data...");
        JSONArray data = new JSONArray();
        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("example.json", StandardCharsets.UTF_8));
            JSONObject jsonObject = (JSONObject) obj;
            data = (JSONArray) jsonObject.get("data");

        } catch (IOException | ParseException e) {
            log.error("Error occurred in reading JSON file");
            e.printStackTrace();
        }
        return data;
    }
}
