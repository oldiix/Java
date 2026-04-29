package org.example.medical_laboratory.controller;

import lombok.RequiredArgsConstructor;
import org.example.medical_laboratory.model.Doctor;
import org.example.medical_laboratory.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/doctors", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAll() {
        return doctorService.getAll();
    }

    @GetMapping("/{id}")
    public Doctor getById(@PathVariable Integer id) {
        return doctorService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Doctor> create(@RequestBody Doctor doctor) {
        return new ResponseEntity<>(doctorService.create(doctor), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Doctor update(@PathVariable Integer id, @RequestBody Doctor doctor) {
        return doctorService.update(id, doctor);
    }

    @PatchMapping("/{id}")
    public Doctor patch(@PathVariable Integer id, @RequestBody Doctor doctor) {
        return doctorService.patch(id, doctor);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        doctorService.delete(id);
    }
}