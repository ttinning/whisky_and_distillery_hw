package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getAllWhiskies(
            @RequestParam(name = "year", required = false) Integer year,
            @RequestParam(name = "age", required = false) Integer age,
            @RequestParam(name = "region", required = false) String region,
            @RequestParam(name = "distillery_id", required = false) Long distilleryId
    ) {
        if (year != null) {
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
        }
        if (distilleryId != null && age != null) {
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskyByDistilleryIdAndAgeGreaterThan(distilleryId, age), HttpStatus.OK);
        }
        if (region != null) {
            return new ResponseEntity<List<Whisky>>(whiskyRepository.findWhiskyByDistilleryRegion(region), HttpStatus.OK);
        }
        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
    }


}
