package com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.domain.service;

import com.zomu.t.epion.tropic.test.tool.epiont3targetappreset.app.v1.control.InlineResponse200;
import com.zomu.t.epion.tropic.test.tool.epiont3targetappreset.app.v1.control.StubApiDelegate;
import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.app.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StubApiServiceImpl implements StubApiDelegate {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public ResponseEntity<InlineResponse200> getStubData() {

        User user = restTemplate.getForObject("http://stub:8080/user", User.class);

        InlineResponse200 res = new InlineResponse200();

        if(user != null){
            res.setName(user.getName());
            res.setSex(user.getSex());
            res.setHeight(user.getHeight());
            res.setWeight(user.getWeight());
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }
}
