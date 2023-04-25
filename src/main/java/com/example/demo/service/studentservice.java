package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Studentdetails;
import com.example.demo.repository.StudentsDetails;

@Service
public class studentservice {
	@Autowired
	public StudentsDetails crepo;
	public Studentdetails saveDetails(Studentdetails d)
	{
		return crepo.save(d);
	}
	//getting the information
	public List<Studentdetails>getDetails()
	{
		return crepo.findAll();
	}
	//updating the information
	public Studentdetails updateDetails(Studentdetails j)
	{
		return crepo.saveAndFlush(j);
	}
	//deleting the information
	public void deleteDetails(int id)
	{
		crepo.deleteById(id);
	}





}

