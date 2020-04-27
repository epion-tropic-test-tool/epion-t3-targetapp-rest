package com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.domain.service;

import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.app.bean.User;
import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.app.configuration.properties.AppConfig;
import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.app.v1.control.InlineResponse200;
import com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.app.v1.control.StubApiDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class StubRestServiceImpl implements StubApiDelegate {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    AppConfig appConfig;

    @Override
    public ResponseEntity<InlineResponse200> getUserData(Integer id) {

        URI url = UriComponentsBuilder.fromHttpUrl(appConfig.getStubUrl())
                .queryParam("id", id)
                .build()
                .toUri();

        User user = restTemplate.getForObject(url, User.class);

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
