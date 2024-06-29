package com.example.HackRush.repo;

import com.example.HackRush.Model.ThemeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeTypeRepo extends JpaRepository<ThemeType,Integer> {
}
