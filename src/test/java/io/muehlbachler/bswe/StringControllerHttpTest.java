package io.muehlbachler.bswe;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.hamcrest.Matchers;

@SpringBootTest
@AutoConfigureMockMvc
public class StringControllerHttpTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testToUpperCase() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/upper?string=abc")).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("ABC")));
    }

    @Test
    public void testToUpperCaseNull() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/upper?string")).andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(result -> assertEquals("String must not be null", result.getResolvedException().getMessage()));
    }
}
