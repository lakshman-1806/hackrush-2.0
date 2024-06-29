package com.example.HackRush.Model;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ThemeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ttid;
    private String ttname;

    @OneToMany(mappedBy = "tt")
    private List<Theme> themes;
}