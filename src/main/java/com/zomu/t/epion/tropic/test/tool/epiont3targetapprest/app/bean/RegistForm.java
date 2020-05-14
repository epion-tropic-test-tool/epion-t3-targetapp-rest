package com.zomu.t.epion.tropic.test.tool.epiont3targetapprest.app.bean;

import lombok.Data;

@Data
public class RegistForm {

    // タイトル
    private String title;

    // 説明
    private String description;

    // 開始時刻
    private String start;

    // 終了時刻
    private String due;

    // 優先度
    private String priority;
}
