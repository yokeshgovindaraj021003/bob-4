package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.model;
import com.example.demo.repository.reposit;

@Service
public class service {
	@Autowired
	private reposit mrepo;
	
	public String checkLogin(String uname, String pwd) {
	    model user = mrepo.findByuname(uname);
	    if (user == null) {
	      return "no user found";
	    }
	    else{
	    	if(user.getPwd().equals(pwd)) {	    		
	    		return"Login Succesfull"; 
	    	}
	    	else {
	    		return "Login Failed";
	    	}
	    }
	}
	public model addUser(model game) {
		return mrepo.save(game);
	}
	public List<model> getUser()
	{
		return mrepo.findAll();
	}
}
