package com.jeremy.resource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.jeremy.model.AppointmentMessage;
import com.jeremy.service.AppoinmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppointmentResource {

    private final AppoinmentService appoinmentService;

    public AppointmentResource(AppoinmentService appoinmentService) {
        this.appoinmentService = appoinmentService;
    }

    @PostMapping("/appointments")
    public ResponseEntity makeAppointment(@RequestBody AppointmentMessage appointmentMessage) throws JsonProcessingException{
        appoinmentService.makeAppointment(appointmentMessage);
        return new ResponseEntity(appointmentMessage, HttpStatus.CREATED);
    }
}
