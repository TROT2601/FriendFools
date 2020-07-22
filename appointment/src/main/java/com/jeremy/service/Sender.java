package com.jeremy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class Sender {

    Logger log = LoggerFactory.getLogger(Sender.class);

    private  final JmsTemplate jms;

    public Sender(JmsTemplate jms) {
        this.jms = jms;
    }

    public void sendMessage(String queue, String message){
        log.info("send message: " + message + "to: " + queue);
        jms.convertAndSend(queue, message);
    }
}
