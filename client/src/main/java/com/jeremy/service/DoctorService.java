package com.jeremy.service;

import com.jeremy.model.Doctor;
import com.jeremy.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements BaseService<Doctor, String>{

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public void create(Doctor doctor) {
        this.doctorRepository.save(doctor);
    }

    @Override
    public void update(Doctor doctor) {
        this.doctorRepository.save(doctor);
    }

    @Override
    public void delete(Doctor doctor) {
        this.doctorRepository.delete(doctor);
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findById(String id) {
        return doctorRepository.findById(id).orElseGet(null);
    }

    @Override
    public List<Doctor> saveAll(List<Doctor> c) {
        return doctorRepository.saveAll(c);
    }
}
