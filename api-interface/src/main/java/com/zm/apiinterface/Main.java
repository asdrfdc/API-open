package com.zm.apiinterface;


import com.zm.apiclientsdk.client.ApiClient;
import com.zm.apiclientsdk.model.User;

public class Main {
    public static void main(String[] args) {
        String accessKey="";
        String secretKey="";
        ApiClient apiClient=new ApiClient(accessKey,secretKey);
        String result=apiClient.getNameByGet("zm");
        String result2 = apiClient.getNameByPost("zm");
        User user=new User();
        user.setUsername("zm");
        String result3 = apiClient.getUsernameByPost(user);
        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);
    }
}
