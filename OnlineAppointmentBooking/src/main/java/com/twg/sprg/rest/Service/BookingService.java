package com.twg.sprg.rest.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twg.sprg.rest.DTO.UserInformation;
import com.twg.sprg.rest.DTO.UserRequest;
import com.twg.sprg.rest.Entity.User;
import com.twg.sprg.rest.Exception.UserNotFoundException;
import com.twg.sprg.rest.Repository.UserRepository;

@Service
public class BookingService {
	
	@Autowired
	UserRepository userRepsitory;

	public UserInformation getUserDetails(long id) {
		
		Optional<User> user=userRepsitory.findById(id);
		if(user.isPresent()) {
			User details=user.get();
			UserInformation info= new UserInformation();
			info.setId(id);
			info.setEmail(details.getEmail());
			info.setName(details.getName());
			info.setRole(details.getRole()); 
			return info;
		}else {
			throw new UserNotFoundException(id);
		}
		
	}

	public UserInformation updateUserDetails(long id, UserRequest req2) {
		
		// TODO Auto-generated method stub
		Optional<User> user=userRepsitory.findById(id);
		if(user.isPresent()) {
			User details=user.get();
			
			
			if(req2.getName()!=null) details.setName(req2.getName());
			if(req2.getEmail()!=null) details.setEmail(req2.getEmail());
			if(req2.getRole()!=null) details.setRole(req2.getRole());
			userRepsitory.save(details);
			UserInformation info= new UserInformation(id, details.getName(), details.getEmail(), details.getRole());
			return info;
		}else {
			throw new UserNotFoundException(id);
		}
		
		
	}

}
