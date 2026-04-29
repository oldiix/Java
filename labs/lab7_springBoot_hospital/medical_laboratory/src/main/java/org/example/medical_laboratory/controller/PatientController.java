package org.example.medical_laboratory.controller;

import lombok.RequiredArgsConstructor;
import org.example.medical_laboratory.model.Patient;
import org.example.medical_laboratory.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/patients", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping
    public List<Patient> getAll() {
        return patientService.getAll();
    }

    @GetMapping("/{id}")
    public Patient getById(@PathVariable Integer id) {
        return patientService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Patient> create(@RequestBody Patient patient) {
        return new ResponseEntity<>(patientService.create(patient), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Patient update(@PathVariable Integer id, @RequestBody Patient patient) {
        return patientService.update(id, patient);
    }

    @PatchMapping("/{id}")
    public Patient patch(@PathVariable Integer id, @RequestBody Patient patient) {
        return patientService.patch(id, patient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        patientService.delete(id);
    }
}