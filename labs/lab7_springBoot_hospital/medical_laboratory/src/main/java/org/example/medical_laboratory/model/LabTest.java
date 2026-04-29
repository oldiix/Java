package org.example.medical_laboratory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LabTest {
    private Integer id;
    private String name;
    private String description;
    private String category;
    private Double price;
}