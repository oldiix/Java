package org.example.medical_laboratory.service;

import lombok.RequiredArgsConstructor;
import org.example.medical_laboratory.model.Equipment;
import org.example.medical_laboratory.repository.EquipmentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public List<Equipment> getAll() {
        return equipmentRepository.findAll();
    }

    public Equipment getById(Integer id) {
        return equipmentRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Обладнання з id=" + id + " не знайдено"));
    }

    public Equipment create(Equipment equipment) {
        equipment.setId(null);
        return equipmentRepository.save(equipment);
    }

    public Equipment update(Integer id, Equipment equipment) {
        if (!equipmentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Обладнання з id=" + id + " не знайдено");
        }
        equipment.setId(id);
        return equipmentRepository.save(equipment);
    }

    public Equipment patch(Integer id, Equipment patch) {
        Equipment existing = getById(id);
        if (patch.getName() != null) existing.setName(patch.getName());
        if (patch.getModel() != null) existing.setModel(patch.getModel());
        if (patch.getSerialNumber() != null) existing.setSerialNumber(patch.getSerialNumber());
        if (patch.getStatus() != null) existing.setStatus(patch.getStatus());
        if (patch.getLastServiceDate() != null) existing.setLastServiceDate(patch.getLastServiceDate());
        return equipmentRepository.save(existing);
    }

    public void delete(Integer id) {
        if (!equipmentRepository.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Обладнання з id=" + id + " не знайдено");
        }
    }
}