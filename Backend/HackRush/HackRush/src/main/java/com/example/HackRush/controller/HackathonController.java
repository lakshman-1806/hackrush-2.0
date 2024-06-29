package com.example.HackRush.controller;

import com.example.HackRush.Model.Hackathon;
import com.example.HackRush.Model.ResourceNotFoundException;
import com.example.HackRush.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hackathons")
public class HackathonController {
    @Autowired
    private HackathonRepo hackathonRepo;

    @GetMapping
    public List<Hackathon> getAllHackathons() {
        return hackathonRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hackathon> getHackathonById(@PathVariable(value = "id") int hackathonId) {
        Hackathon hackathon = hackathonRepo.findById(hackathonId)
                .orElseThrow(() -> new ResourceNotFoundException("Hackathon not found with id: " + hackathonId));
        return ResponseEntity.ok().body(hackathon);
    }

    @PostMapping
    public Hackathon createHackathon(@RequestBody Hackathon hackathon) {
        return hackathonRepo.save(hackathon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hackathon> updateHackathon(@PathVariable(value = "id") int hackathonId,
                                                     @RequestBody Hackathon hackathonDetails) {
        Hackathon hackathon = hackathonRepo.findById(hackathonId)
                .orElseThrow(() -> new ResourceNotFoundException("Hackathon not found with id: " + hackathonId));

        hackathon.setHname(hackathonDetails.getHname());
        hackathon.setHdate(hackathonDetails.getHdate());
        hackathon.setDuration(hackathonDetails.getDuration());
        hackathon.setTimings(hackathonDetails.getTimings());
        hackathon.setVenue(hackathonDetails.getVenue());

        final Hackathon updatedHackathon = hackathonRepo.save(hackathon);
        return ResponseEntity.ok(updatedHackathon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHackathon(@PathVariable(value = "id") int hackathonId) {
        Hackathon hackathon = hackathonRepo.findById(hackathonId)
                .orElseThrow(() -> new ResourceNotFoundException("Hackathon not found with id: " + hackathonId));

        hackathonRepo.delete(hackathon);
        return ResponseEntity.ok().build();
    }
}

