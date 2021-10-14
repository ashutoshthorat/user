package com.bridgelabz.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.demo.dto.UserDTO;
import com.bridgelabz.demo.service.IUserService;
import com.bridgelabz.demo.util.Response;
import com.bridgelabz.demo.util.ResponseAllUser;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	IUserService iservice;
	
	@PostMapping("/register")
	public ResponseEntity<Response> register(@RequestBody UserDTO userdto){
		Response response=iservice.adduser(userdto);
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
	@GetMapping("/findall/{token}")
	public ResponseEntity<ResponseAllUser> getalluser(@PathVariable(value = "token") String token){
		ResponseAllUser response=iservice.getalluser(token);
		return new ResponseEntity<ResponseAllUser>(response,HttpStatus.OK);
		
	}
	
	@GetMapping("/isuserpresent/{token}")
	public boolean isuserpresent(@PathVariable(value = "token") String token) {
		return iservice.getuser(token);
	}
	
//	new ResponseAllUser(200,"get all user hit",token);
}
