package com.jeremy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeremy.model.AppointmentMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AppoinmentService {

    private final Sender sender;
    private final RestTemplate restTemplate;

    public AppoinmentService(Sender sender, RestTemplate restTemplate) {
        this.sender = sender;
        this.restTemplate = restTemplate;
    }

    public void makeAppointment(AppointmentMessage appointmentMessage) throws JsonProcessingException{
        ObjectMapper om = new ObjectMapper();
        String message = om.writeValueAsString(appointmentMessage);
        sender.sendMessage("friendfools.appointment.queue", message);
    }
}
