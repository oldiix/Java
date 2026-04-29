package org.example.medical_laboratory.repository;

import org.example.medical_laboratory.model.TestResult;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Repository
public class TestResultRepository {

    private final Map<Integer, TestResult> storage = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public TestResultRepository() {
        save(new TestResult(null, 1, 1, 1, "4.5", "10^12/L", "COMPLETED", "2024-11-01"));
        save(new TestResult(null, 2, 2, 2, "5.6", "mmol/L", "PENDING", "2024-11-05"));
    }

    public List<TestResult> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<TestResult> findById(Integer id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<TestResult> findByPatientId(Integer patientId) {
        return storage.values().stream()
                .filter(r -> r.getPatientId().equals(patientId))
                .collect(Collectors.toList());
    }

    public TestResult save(TestResult testResult) {
        if (testResult.getId() == null) {
            testResult.setId(idCounter.getAndIncrement());
        }
        storage.put(testResult.getId(), testResult);
        return testResult;
    }

    public boolean deleteById(Integer id) {
        return storage.remove(id) != null;
    }

    public boolean existsById(Integer id) {
        return storage.containsKey(id);
    }
}