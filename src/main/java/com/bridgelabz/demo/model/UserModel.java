package com.bridgelabz.demo.model;

import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
@Table(name="user_details")
public class UserModel {
	@Id
	@GenericGenerator(name = "user_details", strategy = "increment")
	@GeneratedValue(generator = "user_details")
	private Long Id;
	private String firstName;
	private String lastname;
	private String emailid;
	private String password;
	private String mobileNo;
	private LocalDateTime registeredDate;
	private LocalDateTime updatedDate;
	

}
