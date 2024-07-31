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
public class Librarian {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "libId",length = 20)
	private int lid;
	@Column(name = "libname",length = 30)
	private String name;
	@Column(name = "empno",length = 20)
	private int eno;
	@Column(name = "contno",length = 12)
	private long cno;
	

}
