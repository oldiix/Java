package org.example.medical_laboratory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestResult {
    private Integer id;
    private Integer patientId;
    private Integer labTestId;
    private Integer doctorId;
    private String resultValue;
    private String unit;
    private String status;
    private String createdAt;
}