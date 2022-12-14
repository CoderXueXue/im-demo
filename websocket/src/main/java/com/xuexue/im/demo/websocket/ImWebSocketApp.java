package com.xuexue.im.demo.websocket;

import com.xuexue.im.demo.websocket.server.ImWebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author huchai
 * @date 2022/12/12
 */
@Slf4j
@SpringBootApplication
public class ImWebSocketApp implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private ImWebSocketServer imWebSocketServer;


    public static void main(String[] args) {
        SpringApplication.run(ImWebSocketApp.class, args);
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        log.info("#ApplicationReadyEvent# received.");
        log.info("IM start >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        imWebSocketServer.start();
        log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }
}
