package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.metadata.ValidateUnwrappedValue;
import java.util.List;

@RestController
public class DistilleryController {

    @Autowired
    DistilleryRepository distilleryRepository;

    @GetMapping(value = "/distilleries")
    public ResponseEntity<List<Distillery>> getAllDistilleries(
            @RequestParam(name = "region", required = false) String region,
            @RequestParam(name = "age", required = false) Integer age
    ) {
        if (region != null) {
            return new ResponseEntity<List<Distillery>>(distilleryRepository.findDistilleryByRegion(region), HttpStatus.OK);
        }
        if (age != null) {
            return new ResponseEntity<List<Distillery>>(distilleryRepository.findDistilleryByWhiskiesAgeGreaterThan(age), HttpStatus.OK);
        }
        return new ResponseEntity<List<Distillery>>(distilleryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/distilleries/{id}")
    public ResponseEntity getDistillery(@PathVariable Long id) {
        return new ResponseEntity<>(distilleryRepository.findById(id), HttpStatus.OK);
    }

}
