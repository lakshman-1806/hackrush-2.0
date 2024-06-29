package com.example.HackRush.controller;

import com.example.HackRush.Model.Member;
import com.example.HackRush.Model.ResourceNotFoundException;
import com.example.HackRush.repo.MemberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {
    @Autowired
    private MemberRepo memberRepo;

    @GetMapping
    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable(value = "id") int memberId) {
        Member member = memberRepo.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + memberId));
        return ResponseEntity.ok().body(member);
    }

    @PostMapping
    public Member createMember(@RequestBody Member member) {
        return memberRepo.save(member);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable(value = "id") int memberId,
                                               @RequestBody Member memberDetails) {
        Member member = memberRepo.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + memberId));

        member.setRollNo(memberDetails.getRollNo());
        member.setMname(memberDetails.getMname());
        member.setBranchSection(memberDetails.getBranchSection());
        member.setEmail(memberDetails.getEmail());
        member.setMobile(memberDetails.getMobile());
        member.setTeam(memberDetails.getTeam());

        final Member updatedMember = memberRepo.save(member);
        return ResponseEntity.ok(updatedMember);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable(value = "id") int memberId) {
        Member member = memberRepo.findById(memberId)
                .orElseThrow(() -> new ResourceNotFoundException("Member not found with id: " + memberId));

        memberRepo.delete(member);
        return ResponseEntity.ok().build();
    }
}
