package com.example.HackRush.repo;

import com.example.HackRush.Model.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThemeRepo extends JpaRepository<Theme,Integer> {
}
