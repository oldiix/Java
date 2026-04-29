package org.example.medical_laboratory.repository;

import org.example.medical_laboratory.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class PatientRepository {

    private final Map<Integer, Patient> storage = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public PatientRepository() {
        save(new Patient(null, "Анастасія", "Дем'янчук", "2007-10-01", "+380501234567", "anastasiia@gmail.com"));
        save(new Patient(null, "Дорофтей", "Катерина", "2007-02-27", "+380990128525", "kateryna@gmail.com"));
    }

    public List<Patient> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Patient> findById(Integer id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Patient save(Patient patient) {
        if (patient.getId() == null) {
            patient.setId(idCounter.getAndIncrement());
        }
        storage.put(patient.getId(), patient);
        return patient;
    }

    public boolean deleteById(Integer id) {
        return storage.remove(id) != null;
    }

    public boolean existsById(Integer id) {
        return storage.containsKey(id);
    }
}