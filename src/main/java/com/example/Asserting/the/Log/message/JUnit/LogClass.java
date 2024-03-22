package com.example.Asserting.the.Log.message.JUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogClass {

    static final Logger LOGGER = LoggerFactory.getLogger(LogClass.class);

    public void doThat() {
        LOGGER.info("start");
        //...
        LOGGER.info("finish");
    }
}
