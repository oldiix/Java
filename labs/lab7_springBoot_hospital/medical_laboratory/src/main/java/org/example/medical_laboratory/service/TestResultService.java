package org.example.medical_laboratory.service;

import lombok.RequiredArgsConstructor;
import org.example.medical_laboratory.model.TestResult;
import org.example.medical_laboratory.repository.TestResultRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestResultService {

    private final TestResultRepository testResultRepository;

    public List<TestResult> getAll() {
        return testResultRepository.findAll();
    }

    public TestResult getById(Integer id) {
        return testResultRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Результат з id=" + id + " не знайдено"));
    }

    public List<TestResult> getByPatientId(Integer patientId) {
        return testResultRepository.findByPatientId(patientId);
    }

    public TestResult create(TestResult testResult) {
        testResult.setId(null);
        return testResultRepository.save(testResult);
    }

    public TestResult update(Integer id, TestResult testResult) {
        if (!testResultRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Результат з id=" + id + " не знайдено");
        }
        testResult.setId(id);
        return testResultRepository.save(testResult);
    }

    public TestResult patch(Integer id, TestResult patch) {
        TestResult existing = getById(id);
        if (patch.getResultValue() != null) existing.setResultValue(patch.getResultValue());
        if (patch.getUnit() != null) existing.setUnit(patch.getUnit());
        if (patch.getStatus() != null) existing.setStatus(patch.getStatus());
        if (patch.getPatientId() != null) existing.setPatientId(patch.getPatientId());
        if (patch.getLabTestId() != null) existing.setLabTestId(patch.getLabTestId());
        if (patch.getDoctorId() != null) existing.setDoctorId(patch.getDoctorId());
        return testResultRepository.save(existing);
    }

    public void delete(Integer id) {
        if (!testResultRepository.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Результат з id=" + id + " не знайдено");
        }
    }
}