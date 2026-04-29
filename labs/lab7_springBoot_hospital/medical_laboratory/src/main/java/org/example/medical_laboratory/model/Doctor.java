package org.example.medical_laboratory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    private Integer id;
    private String firstName;
    private String lastName;
    private String specialization;
    private String licenseNumber;
}