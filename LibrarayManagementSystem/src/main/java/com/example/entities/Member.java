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
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "memId",length = 20)
	private int mid;
	@Column(name = "memname",length = 20)
	private String name;
	@Column(name = "memaddress",length = 50)
	private String address;
	@Column(name = "memtype",length = 20)
	private String mtype;
	@Column(name = "memdate",length = 20)
	private String expdate;
	private String edate;

}
