package com.zm.apiinterface;

import com.zm.apiclientsdk.client.ApiClient;
import com.zm.apiclientsdk.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class ApiInterfaceApplicationTests {

    @Resource
    private ApiClient apiClient;

    @Test
    void contextLoads() {
        String name = apiClient.getNameByGet("zm");
        User user=new User();
        user.setUsername("zm");
        String username = apiClient.getUsernameByPost(user);
        System.out.println(name);
        System.out.println(username);
    }

}
