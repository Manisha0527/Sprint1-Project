package com.example.service;

import java.util.List;

import com.example.entities.Book;
import com.example.model.BookDTO;

public interface BookService {
	public BookDTO saveBookInfo(Book book);
	public List<BookDTO> getAllBookInfo();
	BookDTO getByBookId(int bid);
	String deleteBookInfoById(int bid);
	BookDTO updateBookInfo(int bid,Book book);
	}


