package com.example.Utitity;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.example.entities.Book;
import com.example.entities.Librarian;
import com.example.entities.Loan;
import com.example.entities.Member;
import com.example.model.BookDTO;
import com.example.model.LibrarianDTO;
import com.example.model.LoanDTO;
import com.example.model.MemberDTO;

@Component
public class BookConverter {
public Book convertToBookEntity(BookDTO bookDTO) {
	
	Book book=new Book();
	if(bookDTO!= null) {
		BeanUtils.copyProperties(bookDTO, book);
	}
	return book;
	
}
public BookDTO convertToBookDTO(Book book) { 
	BookDTO bookDTO=new BookDTO();
	if(book!=null) {
		BeanUtils.copyProperties(book, bookDTO);
	}
 return bookDTO;
}
}



