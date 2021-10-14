package com.bridgelabz.demo.service;

import org.springframework.stereotype.Service;

import com.bridgelabz.demo.dto.UserDTO;
import com.bridgelabz.demo.util.Response;
import com.bridgelabz.demo.util.ResponseAllUser;

@Service
public interface IUserService {

	Response adduser(UserDTO userdto);

	ResponseAllUser getalluser(String token);

	boolean getuser(String token);

}
