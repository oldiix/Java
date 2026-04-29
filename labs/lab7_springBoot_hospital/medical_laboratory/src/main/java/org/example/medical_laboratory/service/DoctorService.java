package org.example.medical_laboratory.service;

import lombok.RequiredArgsConstructor;
import org.example.medical_laboratory.model.Doctor;
import org.example.medical_laboratory.repository.DoctorRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    public Doctor getById(Integer id) {
        return doctorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Лікаря з id=" + id + " не знайдено"));
    }

    public Doctor create(Doctor doctor) {
        doctor.setId(null);
        return doctorRepository.save(doctor);
    }

    public Doctor update(Integer id, Doctor doctor) {
        if (!doctorRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Лікаря з id=" + id + " не знайдено");
        }
        doctor.setId(id);
        return doctorRepository.save(doctor);
    }

    public Doctor patch(Integer id, Doctor patch) {
        Doctor existing = getById(id);
        if (patch.getFirstName() != null) existing.setFirstName(patch.getFirstName());
        if (patch.getLastName() != null) existing.setLastName(patch.getLastName());
        if (patch.getSpecialization() != null) existing.setSpecialization(patch.getSpecialization());
        if (patch.getLicenseNumber() != null) existing.setLicenseNumber(patch.getLicenseNumber());
        return doctorRepository.save(existing);
    }

    public void delete(Integer id) {
        if (!doctorRepository.deleteById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Лікаря з id=" + id + " не знайдено");
        }
    }
}