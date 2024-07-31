package com.example.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.Utitity.LoanConverter;
import com.example.entities.Loan;
import com.example.model.LoanDTO;
import com.example.service.LoanService;
import ch.qos.logback.core.pattern.Converter;

@RestController
@RequestMapping("/loan")
public class LoanController {
	@Autowired
private LoanService loanService;
	@Autowired
	LoanConverter loanConverter;
	@PostMapping("/add")
	ResponseEntity<LoanDTO> add(@RequestBody LoanDTO loanDTO) {
		  final	Loan loan=loanConverter.convertToLoanEntity(loanDTO);
			return new  ResponseEntity<LoanDTO>(loanService.saveLoanInfo(loan),HttpStatus.CREATED);
	}
		@GetMapping("/getAll")
		public List<LoanDTO> getAllLoanInfo(){
			return loanService.getAllLoanInfo();
		}
		@GetMapping("/getByLoanId/{lId}")
		public LoanDTO getByLoanId(@PathVariable("lId")  int lid) {
			
			
			return loanService.getByLoanId(lid);
		}

		@DeleteMapping("/deleteLoanById/{lId}")
		public String deleteLoanById(@PathVariable("lId")  int lid ) {
			// TODO Auto-generated method stub
			return loanService.deleteLoanInfoById(lid);
		}

	   @PutMapping("/updateLoan/{lId}")
		public LoanDTO updateLoan( @PathVariable("lId") int lid,@RequestBody Loan loan) {
			// TODO Auto-generated method stub
		   return loanService.updateLoanInfo(lid, loan);
		}
	}




