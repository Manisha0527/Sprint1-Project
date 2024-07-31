package com.example.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bkId",length = 20)
	private int bid ;
	@Column(name = "btitle",length = 50)
	private String title;
	@Column(name = "bkprice",length = 20)
	private int price;
	@Column(name = "bkauthor",length = 30)
	private String author;
	@Column(name = "bkavailable",length = 20)
	private int available;
	

}
