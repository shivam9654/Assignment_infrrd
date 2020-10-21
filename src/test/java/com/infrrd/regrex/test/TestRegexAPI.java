package com.infrrd.regrex.test;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.infrrd.regrex.MainController;

public class TestRegexAPI {

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new MainController()).build();
    }

    @Test
    public void testPatternMatcher1() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/matchpattern")
        		.content("{\"regex\":\"(x+x+)+y\", \"textBody\":\"yxxxyxxxyxxxxy\"}")
        		.contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.match").value("xxxy"))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.error").value(false));
    }
    
    
    @Test
    public void testPatternMatcher2() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.post("/matchpattern")
        		.content("{\"regex\":\"(x+x+)+y\", \"textBody\":\"yxxxyxxxyxxxxy       xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\"}")
        		.contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.match").value(""))
        		.andExpect(MockMvcResultMatchers.jsonPath("$.error").value(true));
    }
    
    
    
    
    
}