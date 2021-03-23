package com.it.springcloud.configClient.controller.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class ConfigDao {
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Value(value = "${spring.eureka.instance.hostname}")
    private String word;
}
