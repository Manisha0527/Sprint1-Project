package com.example.Utitity;

import org.springframework.beans.BeanUtils;

import com.example.entities.Loan;
import com.example.model.LoanDTO;

public class LoanConverter {
	public Loan convertToLoanEntity(LoanDTO loanDTO) {
		Loan loan=new Loan();
		if(loanDTO!=null) {
			BeanUtils.copyProperties(loanDTO, loan);
		}
		return loan;
	}
	public LoanDTO convertToLoanDTO(Loan loan) {
		
		LoanDTO loanDTO=new LoanDTO();
		if(loan!=null) {
			BeanUtils.copyProperties(loan, loanDTO);
		}
		return loanDTO;
	}
	}


