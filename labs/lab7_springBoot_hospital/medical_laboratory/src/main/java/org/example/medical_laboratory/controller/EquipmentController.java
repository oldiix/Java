package org.example.medical_laboratory.controller;

import lombok.RequiredArgsConstructor;
import org.example.medical_laboratory.model.Equipment;
import org.example.medical_laboratory.service.EquipmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/equipment", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class EquipmentController {

    private final EquipmentService equipmentService;

    @GetMapping
    public List<Equipment> getAll() {
        return equipmentService.getAll();
    }

    @GetMapping("/{id}")
    public Equipment getById(@PathVariable Integer id) {
        return equipmentService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Equipment> create(@RequestBody Equipment equipment) {
        return new ResponseEntity<>(equipmentService.create(equipment), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Equipment update(@PathVariable Integer id, @RequestBody Equipment equipment) {
        return equipmentService.update(id, equipment);
    }

    @PatchMapping("/{id}")
    public Equipment patch(@PathVariable Integer id, @RequestBody Equipment equipment) {
        return equipmentService.patch(id, equipment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        equipmentService.delete(id);
    }
}