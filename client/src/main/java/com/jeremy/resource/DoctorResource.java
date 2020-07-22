package com.jeremy.resource;

import com.jeremy.model.Client;
import com.jeremy.model.Doctor;
import com.jeremy.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DoctorResource {

    private final DoctorService doctorService;

    public DoctorResource(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public ResponseEntity findAll(){
        List<Doctor> doctors = doctorService.findAll();
        if (doctors == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(doctors, HttpStatus.OK);
    }

    @GetMapping("/doctors/{id}")
    public ResponseEntity findById(@PathVariable String id){
        Doctor cDoctor = doctorService.findById(id);
        if (cDoctor == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(cDoctor, HttpStatus.OK);
    }

    @PostMapping("/doctors")
    public ResponseEntity create(@RequestBody Doctor doctor){
        doctorService.create(doctor);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/doctors/{id}")
    public ResponseEntity update(@PathVariable String id,
                                 @RequestBody Doctor doctor){
        Doctor cDoctor = doctorService.findById(id);
        if (cDoctor == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        doctor.setId(id);
        doctorService.update(doctor);
        return new ResponseEntity(doctor,HttpStatus.OK);
    }

    @DeleteMapping("/doctors/{id}")
    public ResponseEntity delete(@PathVariable String id,
                                 @RequestBody Doctor doctor){
        Doctor cDoctor = doctorService.findById(id);
        if (cDoctor == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        doctor.setId(id);
        doctorService.delete(doctor);
        return new ResponseEntity(doctor,HttpStatus.OK);
    }
}
