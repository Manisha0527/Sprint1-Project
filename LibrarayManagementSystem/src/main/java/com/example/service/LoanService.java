package com.example.service;

import java.util.List;

import com.example.entities.Loan;
import com.example.model.LoanDTO;

public interface LoanService {
	public LoanDTO saveLoanInfo(Loan loan);
	public List<LoanDTO> getAllLoanInfo();
	LoanDTO getByLoanId(int lid);
	String deleteLoanInfoById(int lid);
	LoanDTO updateLoanInfo(int lid,Loan loan);
}
