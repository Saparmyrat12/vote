package com.epam.vote.controller;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test Restaurant controller.
 * <p/>
 * Copyright (C) 2021
 * <p/>
 * Date: май 28, 2021
 *
 * @author Sapar
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:com.epam.vote.system.controller/spring/spring-context.xml"})
@WebAppConfiguration
public class TestRestaurantController {

    @Value("${app.test.json_file_path}")
    private String filePath;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    protected final HttpHeaders headers = new HttpHeaders();

    @Test
    public void testGetAllRestaurant() throws Exception {
        mockMvc.perform(get("http://localhost:8080/api/restaurant", 0).headers(headers))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(loadJsonFile("expected-restaurants.json"), true));
    }

    protected String loadJsonFile(String fileName) throws IOException {
        File jsonFile = new File(filePath + fileName).getAbsoluteFile();
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(jsonFile), StandardCharsets.UTF_8));
        StringBuilder builder = new StringBuilder();
        while (reader.ready()) {
            builder.append(reader.readLine());
        }
        return builder.toString();
    }
}
