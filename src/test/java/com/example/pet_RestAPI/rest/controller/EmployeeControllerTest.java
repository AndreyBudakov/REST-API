package com.example.pet_RestAPI.rest.controller;

import com.example.pet_RestAPI.AbstractTest;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


class EmployeeControllerTest extends AbstractTest {

    @Override
    protected String getBaseUrl() {
        return "/api/employees";
    }

    @Test
    void CreateAndDeleteEmployee() throws Exception {
        String json = """
        {
          "name": "Вася",
          "age": 25,
          "salary": 50000,
          "specialty": "Java",
          "fullTime": true
        }
        """;

        MvcResult result = mockMvc.perform(post(getBaseUrl())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        String idString = JsonPath.read(response, "$.id");
        UUID id = UUID.fromString(idString);

        mockMvc.perform(delete(getBaseUrl() + "/delete/{id}", id))
                .andExpect(status().isOk());

        mockMvc.perform(get(getBaseUrl() + id))
                .andExpect(status().is4xxClientError());
    }
}
