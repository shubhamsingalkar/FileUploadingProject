package com.jbk.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.User;
import com.jbk.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService service;

	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAll(){


		List<User> all = service.getAll();
		if(all.size()<1) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			return ResponseEntity.of(Optional.of(all));
		}
	}
	//ResponseEntity is used to send HttpStatus.. simillarly we can do it for all handler method
	@GetMapping("/get/{id}")
	public ResponseEntity<User> getone(@PathVariable("id") int id) {
		User user=null;
		try {
			user = service.getOne(id);
		} catch (Exception e) {
			if(user==null) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		}
		return ResponseEntity.of(Optional.of(user));
	}

	@PostMapping("/add")
	public String add(@RequestBody User user) {
		User user2 = service.add(user);
		System.out.println(user2);
		return "Added Successfully";

	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable ("id") int id) {
		service.delete(id);
		return "Deleted Successsfully";
	}

	@PutMapping("/update/{id}")
	public String update(@RequestBody User user, @PathVariable ("id") int userid) {
		service.update(user, userid);
		return "Updated Successfully";
	}


}
