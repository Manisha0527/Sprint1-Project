package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.entities.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{

}
