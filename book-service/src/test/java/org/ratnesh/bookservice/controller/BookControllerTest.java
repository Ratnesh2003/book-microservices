package org.ratnesh.bookservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.assertions.Assertions;
import org.junit.jupiter.api.Test;
import org.ratnesh.bookservice.dto.BookRequest;
import org.ratnesh.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private BookRepository bookRepository;

    @Container
    private static final MongoDBContainer MONGO_DB_CONTAINER = new MongoDBContainer("mongo:4.4.2");

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.data.mongodb.uri", MONGO_DB_CONTAINER::getReplicaSetUrl);
    }

    @Test
    void createBook_success_201() throws Exception {
        BookRequest request = getBookRequest();
        String requestString = objectMapper.writeValueAsString(request);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/book/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestString))
                .andExpect(status().isCreated());

        Assertions.assertTrue(!bookRepository.findAll().isEmpty());
    }

    @Test
    void getAllBook_success_200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/book/all"))
                .andExpect(status().isOk());
    }

    private BookRequest getBookRequest() {
        return new BookRequest(
                "Test Book",
                "Test Author",
                "Test Description",
                100L
        );
    }

}