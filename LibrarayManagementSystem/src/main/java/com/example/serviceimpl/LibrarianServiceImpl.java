package com.example.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Utitity.LibrarianConverter;
import com.example.entities.Book;
import com.example.entities.Librarian;
import com.example.model.BookDTO;
import com.example.model.LibrarianDTO;
import com.example.repository.LibrarianRepository;
import com.example.service.LibrarianService;

@Service
public class LibrarianServiceImpl implements LibrarianService{
	@Autowired
public LibrarianRepository librarianRepository;
	@Autowired
	LibrarianConverter librarianConverter;
	@Override
	public LibrarianDTO saveLibrarianInfo(Librarian librarian) {
		// TODO Auto-generated method stub
		Librarian l= librarianRepository.save(librarian);
		return librarianConverter.convertToLibrarianDTO(l);
	}
	@Override
	public List<LibrarianDTO> getAllLibrarianInfo() {
		// TODO Auto-generated method stub
		List<Librarian>librarians= librarianRepository.findAll();
		List<LibrarianDTO> ltoa=new ArrayList<>();
	for(Librarian l:librarians) {
		ltoa.add(librarianConverter.convertToLibrarianDTO(l));
	}
		return ltoa;
	}
	@Override
	public LibrarianDTO getByLibrarianId(int lid) {
		// TODO Auto-generated method stub
		Librarian l= librarianRepository.findById(lid).get();
		return librarianConverter.convertToLibrarianDTO(l);
	}
	@Override
	public String deleteLibrarianInfoById(int lid) {
		// TODO Auto-generated method stub
		librarianRepository.deleteById(lid);
		return "Librarian Deleted";
	}
	@Override
	public LibrarianDTO updateLibrarianInfo(int lid, Librarian librarian) {
		// TODO Auto-generated method stub
		Librarian l=librarianRepository.findById(lid).get();
		l.setEno(librarian.getEno());
		l.setCno(librarian.getCno());
		l.setName(librarian.getName());
		Librarian ll=librarianRepository.save(l);
		return librarianConverter.convertToLibrarianDTO(ll);
	}
}