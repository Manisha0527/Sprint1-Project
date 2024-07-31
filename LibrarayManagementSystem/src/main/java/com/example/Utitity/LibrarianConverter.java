package com.example.Utitity;

import org.springframework.beans.BeanUtils;

import com.example.entities.Librarian;
import com.example.model.LibrarianDTO;

public class LibrarianConverter {
	public Librarian convertToLibrarianEntity(LibrarianDTO librarianDTO) {
		
		Librarian librarian=new Librarian();
	    if(librarianDTO!=null) {
		BeanUtils.copyProperties(librarianDTO, librarian);
	}
		return librarian;
	}
	public LibrarianDTO convertToLibrarianDTO(Librarian librarian) {
		LibrarianDTO librarianDTO=new LibrarianDTO();
		if(librarian!=null) {
			BeanUtils.copyProperties(librarian, librarianDTO);
		}
		return librarianDTO;
	}

}
