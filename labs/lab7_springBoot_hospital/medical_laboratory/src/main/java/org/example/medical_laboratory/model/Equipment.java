package org.example.medical_laboratory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipment {
    private Integer id;
    private String name;
    private String model;
    private String serialNumber;
    private String status;
    private String lastServiceDate;
}