package com.example.HackRush.Model;

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
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;
    private String tname;

    @ManyToOne
    @JoinColumn(name = "tt_id")
    private ThemeType tt;

    @ManyToOne
    @JoinColumn(name = "hackathon_id")
    private Hackathon h;
}
