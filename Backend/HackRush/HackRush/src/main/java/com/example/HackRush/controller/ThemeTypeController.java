package com.example.HackRush.controller;

import com.example.HackRush.Model.ResourceNotFoundException;
import com.example.HackRush.Model.ThemeType;
import com.example.HackRush.repo.ThemeTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/theme-types")
public class ThemeTypeController {
    @Autowired
    private ThemeTypeRepo themeTypeRepo;

    @GetMapping
    public List<ThemeType> getAllThemeTypes() {
        return themeTypeRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ThemeType> getThemeTypeById(@PathVariable(value = "id") int themeTypeId) {
        ThemeType themeType = themeTypeRepo.findById(themeTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("ThemeType not found with id: " + themeTypeId));
        return ResponseEntity.ok().body(themeType);
    }

    @PostMapping
    public ThemeType createThemeType(@RequestBody ThemeType themeType) {
        return themeTypeRepo.save(themeType);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ThemeType> updateThemeType(@PathVariable(value = "id") int themeTypeId,
                                                     @RequestBody ThemeType themeTypeDetails) {
        ThemeType themeType = themeTypeRepo.findById(themeTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("ThemeType not found with id: " + themeTypeId));

        themeType.setTtname(themeTypeDetails.getTtname());

        final ThemeType updatedThemeType = themeTypeRepo.save(themeType);
        return ResponseEntity.ok(updatedThemeType);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteThemeType(@PathVariable(value = "id") int themeTypeId) {
        ThemeType themeType = themeTypeRepo.findById(themeTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("ThemeType not found with id: " + themeTypeId));

        themeTypeRepo.delete(themeType);
        return ResponseEntity.ok().build();
    }
}