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
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mid;
    private String rollNo;
    private String mname;
    private String branchSection;
    private String email;
    private long mobile;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}