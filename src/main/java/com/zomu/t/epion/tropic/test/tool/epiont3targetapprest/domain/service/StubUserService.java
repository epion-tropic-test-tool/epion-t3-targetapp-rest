package com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StubUserService {

    @Autowired
    StubRestServiceImpl stubRestService;

    /**
     * ユーザデータ取得
     * @param id userId
     */
    public void getUser(Integer id) {
        stubRestService.getUserData(id);
    }
}
