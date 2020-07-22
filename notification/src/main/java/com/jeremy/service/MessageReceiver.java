package com.jeremy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeremy.model.AppointmentMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageReceiver {

    private final SendEmailService sendEmailService;

    public MessageReceiver(SendEmailService sendEmailService) {
        this.sendEmailService = sendEmailService;
    }

    @JmsListener(destination = "friendfools.appointment.queue")
    public void appointmentMsgReceiver(String message){
        log.info(message);
        ObjectMapper om = new ObjectMapper();

        try{
            AppointmentMessage appointmentMessage = om.readValue(message, AppointmentMessage.class);
            sendEmailService.sendEmail(appointmentMessage.getClient().getEmail());
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
    }
}
