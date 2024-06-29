package com.example.HackRush.controller;

import com.example.HackRush.Model.ResourceNotFoundException;
import com.example.HackRush.Model.Theme;
import com.example.HackRush.repo.ThemeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/themes")
public class ThemeController {
    @Autowired
    private ThemeRepo themeRepo;

    @GetMapping
    public List<Theme> getAllThemes() {
        return themeRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Theme> getThemeById(@PathVariable(value = "id") int themeId) {
        Theme theme = themeRepo.findById(themeId)
                .orElseThrow(() -> new ResourceNotFoundException("Theme not found with id: " + themeId));
        return ResponseEntity.ok().body(theme);
    }

    @PostMapping
    public Theme createTheme(@RequestBody Theme theme) {
        return themeRepo.save(theme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Theme> updateTheme(@PathVariable(value = "id") int themeId,
                                             @RequestBody Theme themeDetails) {
        Theme theme = themeRepo.findById(themeId)
                .orElseThrow(() -> new ResourceNotFoundException("Theme not found with id: " + themeId));

        theme.setTname(themeDetails.getTname());
        theme.setTt(themeDetails.getTt());
        theme.setH(themeDetails.getH());

        final Theme updatedTheme = themeRepo.save(theme);
        return ResponseEntity.ok(updatedTheme);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTheme(@PathVariable(value = "id") int themeId) {
        Theme theme = themeRepo.findById(themeId)
                .orElseThrow(() -> new ResourceNotFoundException("Theme not found with id: " + themeId));

        themeRepo.delete(theme);
        return ResponseEntity.ok().build();
    }
}
