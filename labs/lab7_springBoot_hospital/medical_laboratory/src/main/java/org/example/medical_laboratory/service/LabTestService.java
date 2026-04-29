package org.example.medical_laboratory.service;

import lombok.RequiredArgsConstructor;
import org.example.medical_laboratory.model.LabTest;
import org.example.medical_laboratory.repository.LabTestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LabTestService {

    private final LabTestRepository labTestRepository;

    public List<LabTest> getAll() {
        return labTestRepository.findAll();
    }

    public LabTest getById(Integer id) {
        return labTestRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Аналіз з id=" + id + " не знайдено"));
    }

    public LabTest create(LabTest labTest) {
        labTest.setId(null);
        return labTestRepository.save(labTest);
    }

    public LabTest update(Integer id, LabTest labTest) {
        if (!labTestRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Аналіз з id=" + id + " не знайдено");
        }
        labTest.setId(id);
        return labTestRepository.save(labTest);
    }

    public LabTest patch(Integer id, LabTest patch) {
        LabTest existing = getById(id);
        if (patch.getName() != null) existing.setName(patch.getName());
        if (patch.getDescription() != null) existing.setDescription(patch.getDescription());
        if (patch.getCategory() != null) existing.setCategory(patch.getCategory());
        if (patch.getPrice() != null) existing.setPrice(patch.getPrice());
        return labTestRepository.save(existing);
    }

    public void delete(Integer id) {
        if (!labTestRepository.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Аналіз з id=" + id + " не знайдено");
        }
    }
}