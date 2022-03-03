package com.jbk.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.jbk.entity.User;

@Service
public class UserService {
	
	
	static List<User> list=new ArrayList<User>();
	
	
	static {
		
		list.add(new User(12, "Virat","CSE",78956));
		list.add(new User(13, "Suresh", "Mech", 789562));
	}
	
	
	public List<User> getAll(){
		return list;
	}
	
	public User getOne(int id){
		User user=null;
		
		user=list.stream().filter(u->u.getUserid()==id).findFirst().get();
		return user;
	}

	public User add(User user) {
		
		list.add(user);
		return user;
	}

	public void delete(int uid) {
		list = list.stream().filter(n->n.getUserid()!=uid).collect(Collectors.toList());
		
	}
	public void update(User user, int id) {
		
		 list = list.stream().map(n->{
		if(n.getUserid()==id) {
			n.setAmount(user.getAmount());
			n.setBranch(user.getBranch());
			}
		return n;
		}).collect(Collectors.toList());
	}

}
