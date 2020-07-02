package com.xsz.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xsz.entity.User;
import com.xsz.vo.ResultVO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class XSZUtil {
    @Resource
    RestTemplate restTemplate;

    public static void main(String[] args) {
        User user=new User();
        user.setId("32424");
        user.setPwd("dfg345");
        user.setMobile("3453");
        System.out.println(objectToMap(user));
    }

    /**
     *  java 任何对象转成map
     *   <dependency>
     *             <groupId>com.fasterxml.jackson.datatype</groupId>
     *             <artifactId>jackson-datatype-jsr310</artifactId>
     *         </dependency>
     * @param o
     * @return
     */
    public static Map<String,Object> objectToMap(Object o){

        ObjectMapper m = new ObjectMapper();

        return m.convertValue(o,Map.class);
    }

    public static User MapToUser(Map<String,Object> map){

        ObjectMapper m = new ObjectMapper();

        return m.convertValue(map,User.class);
    }

    public ResponseEntity<ResultVO> callService(String url, Map<String, Object>  map){

        HttpHeaders httpHeaders = new HttpHeaders();
        MediaType type= MediaType.parseMediaType("application/json;charset=UTF-8");
        httpHeaders.setContentType(type);
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("name", username);
//        map.put("pwd", password);
        HttpEntity<Map<String, Object>> objectHttpEntity = new HttpEntity<>(map,httpHeaders);
        return  restTemplate.postForEntity(url, objectHttpEntity, ResultVO.class);

    }
}
