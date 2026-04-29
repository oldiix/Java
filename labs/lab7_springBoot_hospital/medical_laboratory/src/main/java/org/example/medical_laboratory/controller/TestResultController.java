package org.example.medical_laboratory.controller;

import lombok.RequiredArgsConstructor;
import org.example.medical_laboratory.model.TestResult;
import org.example.medical_laboratory.service.TestResultService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/test-results", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class TestResultController {

    private final TestResultService testResultService;

    @GetMapping
    public List<TestResult> getAll() {
        return testResultService.getAll();
    }

    @GetMapping("/{id}")
    public TestResult getById(@PathVariable Integer id) {
        return testResultService.getById(id);
    }

    @GetMapping("/patient/{patientId}")
    public List<TestResult> getByPatientId(@PathVariable Integer patientId) {
        return testResultService.getByPatientId(patientId);
    }

    @PostMapping
    public ResponseEntity<TestResult> create(@RequestBody TestResult testResult) {
        return new ResponseEntity<>(testResultService.create(testResult), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public TestResult update(@PathVariable Integer id, @RequestBody TestResult testResult) {
        return testResultService.update(id, testResult);
    }

    @PatchMapping("/{id}")
    public TestResult patch(@PathVariable Integer id, @RequestBody TestResult testResult) {
        return testResultService.patch(id, testResult);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        testResultService.delete(id);
    }
}