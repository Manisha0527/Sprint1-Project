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

import com.example.Utitity.LibrarianConverter;
import com.example.entities.Librarian;
import com.example.model.LibrarianDTO;
import com.example.service.LibrarianService;
import ch.qos.logback.core.pattern.Converter;

@RestController
@RequestMapping("/librarian")
public class LibrarianController {
	@Autowired
private LibrarianService librarianService;
	@Autowired
	LibrarianConverter librarianConverter;
	@PostMapping("/add")
	ResponseEntity<LibrarianDTO> add(@RequestBody LibrarianDTO librarianDTO) {
		  final	Librarian librarian=librarianConverter.convertToLibrarianEntity(librarianDTO);
			return new  ResponseEntity<LibrarianDTO>(librarianService.saveLibrarianInfo(librarian),HttpStatus.CREATED);
	}
		@GetMapping("/getAll")
		public List<LibrarianDTO> getAllLibrarianInfo(){
			return librarianService.getAllLibrarianInfo();
		}
		@GetMapping("/getByLibrarianId/{lId}")
		public LibrarianDTO getByLibrarianId(@PathVariable("lId")  int lid) {
			
			
			return librarianService.getByLibrarianId(lid);
		}

		@DeleteMapping("/deleteLibrarianById/{lId}")
		public String deleteLibrarianById(@PathVariable("lId")  int lid ) {
			// TODO Auto-generated method stub
			return librarianService.deleteLibrarianInfoById(lid);
		}

	   @PutMapping("/updateLoan/{lId}")
		public LibrarianDTO updateLibrarian( @PathVariable("lId") int lid,@RequestBody Librarian librarian) {
			// TODO Auto-generated method stub
		   return librarianService.updateLibrarianInfo(lid, librarian);
		}
	}



