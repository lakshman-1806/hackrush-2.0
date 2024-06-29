package com.example.HackRush.repo;

import com.example.HackRush.Model.Hackathon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HackathonRepo extends JpaRepository<Hackathon,Integer> {
}
