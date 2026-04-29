package org.example.medical_laboratory.repository;

import org.example.medical_laboratory.model.LabTest;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class LabTestRepository {

    private final Map<Integer, LabTest> storage = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public LabTestRepository() {
        save(new LabTest(null, "Загальний аналіз крові", "Визначення складу крові", "Hematology", 150.0));
        save(new LabTest(null, "Глюкоза крові", "Рівень цукру в крові", "Biochemistry", 80.0));
        save(new LabTest(null, "Загальний аналіз сечі", "Дослідження сечі", "Urinalysis", 100.0));
    }

    public List<LabTest> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<LabTest> findById(Integer id) {
        return Optional.ofNullable(storage.get(id));
    }

    public LabTest save(LabTest labTest) {
        if (labTest.getId() == null) {
            labTest.setId(idCounter.getAndIncrement());
        }
        storage.put(labTest.getId(), labTest);
        return labTest;
    }

    public boolean deleteById(Integer id) {
        return storage.remove(id) != null;
    }

    public boolean existsById(Integer id) {
        return storage.containsKey(id);
    }
}