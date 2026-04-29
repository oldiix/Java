package org.example.medical_laboratory.repository;

import org.example.medical_laboratory.model.Equipment;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EquipmentRepository {

    private final Map<Integer, Equipment> storage = new HashMap<>();
    private final AtomicInteger idCounter = new AtomicInteger(1);

    public EquipmentRepository() {
        save(new Equipment(null, "Гематологічний аналізатор", "Sysmex XN-1000", "SN-001", "ACTIVE", "2024-09-15"));
        save(new Equipment(null, "Центрифуга", "Eppendorf 5810R", "SN-002", "MAINTENANCE", "2024-10-01"));
    }

    public List<Equipment> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Equipment> findById(Integer id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Equipment save(Equipment equipment) {
        if (equipment.getId() == null) {
            equipment.setId(idCounter.getAndIncrement());
        }
        storage.put(equipment.getId(), equipment);
        return equipment;
    }

    public boolean deleteById(Integer id) {
        return storage.remove(id) != null;
    }

    public boolean existsById(Integer id) {
        return storage.containsKey(id);
    }
}