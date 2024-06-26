package com.zm.apiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.zm.apiclientsdk.model.User;

import java.util.HashMap;
import java.util.Map;

import static com.zm.apiclientsdk.utils.SignUtils.genSign;


/**
 * 调用第三方接口的客户端
 */
public class ApiClient {

    private static final String GATEWAY_HOST = "http://localhost:8090";
    private String accessKey;

    private String secretKey;

    public ApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }
    public String getNameByGet(String username) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", username);
        String result= HttpUtil.get(GATEWAY_HOST+"/api/name", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost( String username) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", username);
        String result= HttpUtil.post(GATEWAY_HOST+"/api/name", paramMap);
        System.out.println(result);
        return result;
    }



    private Map<String, String> getHeaderMap(String body){
        Map<String,String> headerMap=new HashMap<>();
        headerMap.put("accessKey",accessKey);
        //不能传送密码
        //headerMap.put("secretKey",secretKey);
        headerMap.put("nonce", RandomUtil.randomNumbers(4));
        headerMap.put("body",body);
        headerMap.put("timestamp",String.valueOf(System.currentTimeMillis()/1000));
        headerMap.put("sign",genSign(body,secretKey));
        return headerMap;
    }

    public String getUsernameByPost( User user){
        String json= JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST+"/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result=httpResponse.body();
        System.out.println(result);
        return result;
    }

}
