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
public class Hackathon
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hid;
    private String hname;
    private String hdate;
    private Integer duration;
    private String timings;
    private String venue;
}