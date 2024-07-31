package com.example.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.Utitity.BookConverter;
import com.example.entities.Book;
import com.example.model.BookDTO;
import com.example.repository.BookRepository;
import com.example.service.BookService;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
public BookRepository bookRepository;
	@Autowired
	BookConverter bookConverter;
	@Override
	public BookDTO saveBookInfo(Book book) {
		// TODO Auto-generated method stub
		Book b= bookRepository.save(book);
		return bookConverter.convertToBookDTO(b);
	}
	@Override
	public List<BookDTO> getAllBookInfo() {
		// TODO Auto-generated method stub
		List<Book>books= bookRepository.findAll();
		List<BookDTO> btoa=new ArrayList<>();
	for(Book b:books) {
		btoa.add(bookConverter.convertToBookDTO(b));
	}
		return btoa;
	}
	@Override
	public BookDTO getByBookId(int bid) {
		// TODO Auto-generated method stub
		Book b= bookRepository.findById(bid).get();
		return bookConverter.convertToBookDTO(b);
	}
	@Override
	public String deleteBookInfoById(int bid) {
		// TODO Auto-generated method stub
		bookRepository.deleteById(bid);
		return "book info deleted";
	}
	@Override
	public BookDTO updateBookInfo(int bid, Book book) {
		// TODO Auto-generated method stub
		Book b=bookRepository.findById(bid).get();
		b.setTitle(book.getTitle());
		b.setAuthor(book.getAuthor());
		b.setPrice(book.getPrice());
		b.setAvailable(book.getAvailable());
		Book bb=bookRepository.save(b);
		return bookConverter.convertToBookDTO(bb);
	}
}
	