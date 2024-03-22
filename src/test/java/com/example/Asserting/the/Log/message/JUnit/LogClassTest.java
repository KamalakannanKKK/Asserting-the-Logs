package com.example.Asserting.the.Log.message.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

class LogClassTest {
    private ListAppender<ILoggingEvent> listAppender;
    
    @Autowired
    LogClass log;
     
    @BeforeEach
    public void setUp() {

        listAppender = new ListAppender<>();
        listAppender.start();
        ch.qos.logback.classic.Logger logger = (ch.qos.logback.classic.Logger) LoggerFactory.getLogger(LogClass.class);
        logger.addAppender(listAppender);

    }
 
    @AfterEach
    public void stopList() {

        listAppender.stop();
        
    }
	
	@Test
	void test() {
        
        // call method under test
        LogClass foo = new LogClass();
        foo.doThat();

        // JUnit assertions
        List<ILoggingEvent> logsList = listAppender.list;
        assertEquals("start", logsList.get(0)
                                      .getMessage());
        assertEquals(Level.INFO, logsList.get(0)
                                         .getLevel());

        assertEquals("finish", logsList.get(1)
                                       .getMessage());
        assertEquals(Level.INFO, logsList.get(1)
                                         .getLevel());
	}

}
