package com.example.demo.test.operations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/get")
public class TestOps {
    Logger logger = LoggerFactory.getLogger(TestOps.class);

    @RequestMapping(value = "/addition/{val1}/{val2}" , method = RequestMethod.GET)
    public void getAdditionValue(@PathVariable int val1, @PathVariable int val2){
        logger.debug("Val1 passed is {}, val2 is {}" , val1 ,val2);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result =  restTemplate.exchange("http://localhost:8081/operations/add/{val1}/{val2}" , HttpMethod.GET , null , String.class ,val1 , val2);

        logger.debug("Result is : {}" , result.getBody());
    }
}
