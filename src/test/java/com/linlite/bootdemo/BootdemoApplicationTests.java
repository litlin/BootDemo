package com.linlite.bootdemo;

import com.linlite.bootdemo.service.UserInfoRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
class BootdemoApplicationTests {


    @Test
    void contextLoads() {
    }

    @Resource
    private WebApplicationContext applicationContext;

    @Test
    void testUrlHome() {
        try {
            MockMvc mvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();
            mvc.perform(MockMvcRequestBuilders.get("/")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Resource
    private UserInfoRepository repository;

    @Test
    void testDB() {
        assert repository.count() > 0;
        assert repository.selectByName("name1") != null;
        repository.findAll().forEach(System.out::println);
    }
}
