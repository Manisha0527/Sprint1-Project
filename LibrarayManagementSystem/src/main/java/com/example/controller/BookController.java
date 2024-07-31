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

import com.example.Utitity.BookConverter;
import com.example.entities.Book;
import com.example.model.BookDTO;
import com.example.model.LibrarianDTO;
import com.example.service.BookService;
import ch.qos.logback.core.pattern.Converter;

@RestController
@RequestMapping("/book")
public class BookController {
	@Autowired
private BookService bookService;
	@Autowired
	BookConverter bookConverter;
	@PostMapping("/add")
	ResponseEntity<BookDTO> add(@RequestBody BookDTO bookDTO) {
		  final	Book book=bookConverter.convertToBookEntity(bookDTO);
			return new  ResponseEntity<BookDTO>(bookService.saveBookInfo(book),HttpStatus.CREATED);
	}
		@GetMapping("/getAll")
		public List<BookDTO> getAllBookInfo(){
			return bookService.getAllBookInfo();
		}
		@GetMapping("/getByBookId/{bId}")
		public BookDTO getByBookId(@PathVariable("bId")  int bid)
		{
			return bookService.getByBookId(bid);
		}

		@DeleteMapping("/deleteBookById/{bId}")
		public String deleteBookById(@PathVariable("bId")  int bid ) {
			// TODO Auto-generated method stub
			return bookService.deleteBookInfoById(bid);
		}

	   @PutMapping("/updateLoan/{bId}")
		public BookDTO updateBook( @PathVariable("bId") int bid,@RequestBody Book book) {
			// TODO Auto-generated method stub
		   return bookService.updateBookInfo(bid, book);
		}
	}




