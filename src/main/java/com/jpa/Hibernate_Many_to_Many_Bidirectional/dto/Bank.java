package com.jpa.Hibernate_Many_to_Many_Bidirectional.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bank {
	
	
	@Id
	
	private int id;
	private String bankName;
	private String address;
	private String ifscCode;
	private int branchCode;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> users;

	public Bank(int id, String bankName, String address, String ifscCode, int branchCode) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.address = address;
		this.ifscCode = ifscCode;
		this.branchCode = branchCode;
	}

	

	

	

	
	}

	
	
	

	

	
	
	


