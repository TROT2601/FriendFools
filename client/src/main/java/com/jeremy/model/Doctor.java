package com.jeremy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Table
@Entity
public class Doctor {

    @Id
    private String id;
    private String nomDoctor;
    private String apeDoctor;
    private Integer dni;
    private String address;
    private Integer telfNumber;
    private String bloodType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthDate;
    private String speciality;
    private String email;
}
