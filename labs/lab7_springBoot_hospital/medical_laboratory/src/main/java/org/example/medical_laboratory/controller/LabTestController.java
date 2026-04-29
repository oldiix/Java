package org.example.medical_laboratory.controller;

import lombok.RequiredArgsConstructor;
import org.example.medical_laboratory.model.LabTest;
import org.example.medical_laboratory.service.LabTestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/lab-tests", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class LabTestController {

    private final LabTestService labTestService;

    @GetMapping
    public List<LabTest> getAll() {
        return labTestService.getAll();
    }

    @GetMapping("/{id}")
    public LabTest getById(@PathVariable Integer id) {
        return labTestService.getById(id);
    }

    @PostMapping
    public ResponseEntity<LabTest> create(@RequestBody LabTest labTest) {
        return new ResponseEntity<>(labTestService.create(labTest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public LabTest update(@PathVariable Integer id, @RequestBody LabTest labTest) {
        return labTestService.update(id, labTest);
    }

    @PatchMapping("/{id}")
    public LabTest patch(@PathVariable Integer id, @RequestBody LabTest labTest) {
        return labTestService.patch(id, labTest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        labTestService.delete(id);
    }
}