package com.twg.sprg.rest.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.twg.sprg.rest.DTO.UserInformation;
import com.twg.sprg.rest.DTO.UserRequest;
import com.twg.sprg.rest.Service.BookingService;

@RestController
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("api/user/{id}")
	public UserInformation getUser(@PathVariable long id)
	{
		UserInformation info=bookingService.getUserDetails(id);
		
		return info;
	}
	
	@PutMapping("api/user/{id}")
	public UserInformation updateUser(@RequestBody UserRequest req,@PathVariable long id)
	{
		UserInformation info=bookingService.updateUserDetails(id,req);
		return info;
	}

}
