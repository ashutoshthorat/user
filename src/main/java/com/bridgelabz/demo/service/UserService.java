package com.bridgelabz.demo.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridgelabz.demo.dto.UserDTO;
import com.bridgelabz.demo.exception.UserException;
import com.bridgelabz.demo.model.UserModel;
import com.bridgelabz.demo.repository.UserRepository;
import com.bridgelabz.demo.util.Email;
import com.bridgelabz.demo.util.Response;
import com.bridgelabz.demo.util.ResponseAllUser;
import com.bridgelabz.demo.util.TokenUtil;

@Service
public class UserService implements IUserService {
	@Autowired
	UserRepository userrepository;
	@Autowired
	PasswordEncoder passwordencoder;
	@Autowired
	TokenUtil tokenutil;
	@Autowired
	Email email;
//	@Autowired
//	MessageProducer messageproducer;

	@Autowired
	MailService mailsender;
	@Autowired
	ModelMapper mapper;
	@Override
	public Response adduser(UserDTO userdto) {
		Optional<UserModel> isuserpresent=userrepository.findByemailid(userdto.getEmailid());
		if(isuserpresent.isPresent()) {
			throw new UserException(400,"user already present");
		}else {
			UserModel model=mapper.map(userdto, UserModel.class);
			model.setPassword(passwordencoder.encode(model.getPassword()));
			model.setRegisteredDate(LocalDateTime.now());
			userrepository.save(model);
			String token=tokenutil.createToken(model.getId());
			email.setTo(model.getEmailid());
			email.setFrom("ashutoshrit64@gmail.com");
			String body="Welcome "+model.getFirstName()+" ";
			email.setSubject("Congratulations!!");
			email.setBody(body);
//			messageproducer.sendMessage(email);
			System.out.println("token"+token);
//			mailsender.send(email.getTo(), email.getFrom(), email.getBody());
			return new Response(200,"user suuccefully registered",token);
		}
	}
	@Override
	public ResponseAllUser getalluser(String token) {
		Long id=(long) 1;
		Optional<UserModel> isUserPresent=userrepository.findById(id);
		if(isUserPresent.isPresent()) {
			return new ResponseAllUser(200,"get all user hit",userrepository.findAll());
		}else {
			throw new UserException(400, "user not present");
		}

	}
	@Override
	public boolean getuser(String token) {
		Optional<UserModel> isUserPresent=userrepository.findById(tokenutil.decodeToken(token));
		if(isUserPresent.isPresent()) {
			return true;
		}
		
		return false;
	}

}
