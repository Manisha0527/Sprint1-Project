package com.example.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Utitity.LoanConverter;
import com.example.entities.Book;
import com.example.entities.Loan;
import com.example.model.LoanDTO;
import com.example.repository.BookRepository;
import com.example.repository.LoanRepository;
import com.example.service.BookService;
import com.example.service.LoanService;


@Service
public class LoanServiceImpl implements LoanService{
	@Autowired
public LoanRepository loanRepository;
	@Autowired
	LoanConverter loanConverter;
	@Override
	public LoanDTO saveLoanInfo(Loan loan) {
		// TODO Auto-generated method stub
		Loan ln=loanRepository.save(loan);
		return loanConverter.convertToLoanDTO(ln);
	}
	@Override
	public List<LoanDTO> getAllLoanInfo() {
		// TODO Auto-generated method stub
		List<Loan> loans=loanRepository.findAll();
		List<LoanDTO>ldto=new ArrayList<>();
	for(Loan l:loans) {
	ldto.add(loanConverter.convertToLoanDTO(l));
	}
		return ldto;
	}
	@Override
	public LoanDTO getByLoanId(int lid) {
		// TODO Auto-generated method stub
		Loan l=loanRepository.findById(lid).get();
		return loanConverter.convertToLoanDTO(l);
	}
	@Override
	public String deleteLoanInfoById(int lid) {
		// TODO Auto-generated method stub
		loanRepository.deleteById(lid);
		return "Loan deleted";
	}
	@Override
	public LoanDTO updateLoanInfo(int lid, Loan loan) {
		// TODO Auto-generated method stub
		Loan l=loanRepository.findById(lid).get();
		l.setBid(loan.getBid());
		l.setLdate(loan.getLdate());
		l.setMid(loan.getMid());
		l.setRdate(loan.getRdate());
		Loan ll=loanRepository.save(l);
		return loanConverter.convertToLoanDTO(ll);
	}
}
