package com.book.demo;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)//开启Spring集成测试支持
@SpringBootTest//加入这个注解在测试环境下才会加载所有配置
public class TestMethod2 {
    @Autowired
    private WebApplicationContext webContext;//注入webContext

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {//设置MockMvc
        mockMvc = MockMvcBuilders.webAppContextSetup(webContext).build();
    }

    @Test
    public void run() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/User/Test")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name","aaa"))//设置参数
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.model().attributeExists("name"))
                .andExpect(MockMvcResultMatchers.model().attribute("name",Matchers.is(Matchers.empty())));
//        java.lang.AssertionError: Model attribute 'name'
//        Expected: is an empty collection
//        but: was a java.lang.String ("xxx")
    }

}
