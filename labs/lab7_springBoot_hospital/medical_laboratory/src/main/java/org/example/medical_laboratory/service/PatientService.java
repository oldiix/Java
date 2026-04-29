package org.example.medical_laboratory.service;

import lombok.RequiredArgsConstructor;
import org.example.medical_laboratory.model.Patient;
import org.example.medical_laboratory.repository.PatientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Patient getById(Integer id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Пацієнта з id=" + id + " не знайдено"));
    }

    public Patient create(Patient patient) {
        patient.setId(null);
        return patientRepository.save(patient);
    }

    public Patient update(Integer id, Patient patient) {
        if (!patientRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Пацієнта з id=" + id + " не знайдено");
        }
        patient.setId(id);
        return patientRepository.save(patient);
    }

    public Patient patch(Integer id, Patient patch) {
        Patient existing = getById(id);
        if (patch.getFirstName() != null) existing.setFirstName(patch.getFirstName());
        if (patch.getLastName() != null) existing.setLastName(patch.getLastName());
        if (patch.getDateOfBirth() != null) existing.setDateOfBirth(patch.getDateOfBirth());
        if (patch.getPhone() != null) existing.setPhone(patch.getPhone());
        if (patch.getEmail() != null) existing.setEmail(patch.getEmail());
        return patientRepository.save(existing);
    }

    public void delete(Integer id) {
        if (!patientRepository.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Пацієнта з id=" + id + " не знайдено");
        }
    }
}