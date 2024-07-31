package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entities.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer>{

}
