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
public class Loan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "lnId",length = 20)
	private int lid;
	@Column(name = "bkId",length = 20)
	private int bid;
	@Column(name = "memId",length = 20)
	private int mid;
	@Column(name = "lndate",length = 20)
	private String ldate;
	@Column(name = "rndate",length = 20)
	private int rdate;

}
