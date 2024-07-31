package com.example.service;

import java.util.List;

import com.example.entities.Librarian;
import com.example.model.LibrarianDTO;

public interface LibrarianService {
	public LibrarianDTO saveLibrarianInfo(Librarian librarian);
	public List<LibrarianDTO> getAllLibrarianInfo();
	LibrarianDTO getByLibrarianId(int lid);
	String deleteLibrarianInfoById(int lid);
	LibrarianDTO updateLibrarianInfo(int lid,Librarian librarian);
}
