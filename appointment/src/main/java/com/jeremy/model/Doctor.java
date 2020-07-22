package com.jeremy.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Doctor {

    private String id;
    private String nomDoctor;
    private String apeDoctor;
    private String Speciality;
}
