package org.example.medical_laboratory.repository;

import org.example.medical_laboratory.model.Doctor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class DoctorRepository {

    private final Map<Integer, Doctor> storage = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public DoctorRepository() {
        save(new Doctor(null, "Іван", "Петренко", "Терапевт", "UA-12345"));
        save(new Doctor(null, "Марія", "Шевченко", "Лор", "UA-67890"));
    }

    public List<Doctor> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Doctor> findById(Integer id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Doctor save(Doctor doctor) {
        if (doctor.getId() == null) {
            doctor.setId(idCounter.getAndIncrement());
        }
        storage.put(doctor.getId(), doctor);
        return doctor;
    }

    public boolean deleteById(Integer id) {
        return storage.remove(id) != null;
    }

    public boolean existsById(Integer id) {
        return storage.containsKey(id);
    }
}