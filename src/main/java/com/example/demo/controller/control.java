package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.model;
import com.example.demo.service.service;

@RestController
@RequestMapping("/games")
public class control {
	@Autowired
	private service serv;
	
	  @PostMapping("/login")
	  public String login(@RequestBody Map<String, String> loginData) {
	    String uname = loginData.get("uname");
	    String pwd = loginData.get("pwd");
	    String result = serv.checkLogin(uname, pwd);
	    return result;
	  }
	  @PostMapping("/adduser")
	  	public model AddUser(@RequestBody model game) {
		  return serv.addUser(game);
	  }
	  
	  @GetMapping("/getlog")
	  public List<model> ListAll()
	  {
		  return serv.getUser();
	  }
}
