package com.jpa.Hibernate_Many_to_Many_Bidirectional.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	private long phone;
	
	private long userAccount;
	
	private LocalDate userDob;
	
	@CreationTimestamp
	private LocalDateTime userCreationDate;
	
	@Transient
	private String userPassword;
	
	
	
	
	@ManyToMany(mappedBy = "users")
	private List<Bank> banks;


	public User(String name, long phone, long userAccount, LocalDate userDob) {
		super();
		this.name = name;
		this.phone = phone;
		this.userAccount = userAccount;
		this.userDob = userDob;
	}
	
	
}
