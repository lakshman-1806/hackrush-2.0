package com.example.HackRush.repo;


import com.example.HackRush.Model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepo extends JpaRepository<Member, Integer> {
    
}
