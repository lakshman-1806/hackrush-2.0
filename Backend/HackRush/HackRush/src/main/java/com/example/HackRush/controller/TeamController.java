package com.example.HackRush.controller;

import com.example.HackRush.Model.ResourceNotFoundException;
import com.example.HackRush.Model.Team;
import com.example.HackRush.repo.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    @Autowired
    private TeamRepo teamRepo;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Team> getTeamById(@PathVariable(value = "id") int teamId) {
        Team team = teamRepo.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + teamId));
        return ResponseEntity.ok().body(team);
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamRepo.save(team);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable(value = "id") int teamId,
                                           @RequestBody Team teamDetails) {
        Team team = teamRepo.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + teamId));

        team.setTname(teamDetails.getTname());

        final Team updatedTeam = teamRepo.save(team);
        return ResponseEntity.ok(updatedTeam);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeam(@PathVariable(value = "id") int teamId) {
        Team team = teamRepo.findById(teamId)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with id: " + teamId));

        teamRepo.delete(team);
        return ResponseEntity.ok().build();
    }
}