package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
	
	//sort by ascending
	public List<Studentdetails> sortAsc(String name)
	{
		return crepo.findAll(Sort.by(name).ascending());
	}

	//pagination
	public List<Studentdetails> paginationAndSorting(int pageNu, int pageSize)
	{
		Page<Studentdetails> p=crepo.findAll(PageRequest.of(pageNu, pageSize));
		return p.getContent();
	}

	//pagination and sorting
	public List<Studentdetails> paginationAndSorting(int pageNu, int pageSize, String pname)
	{
		Page<Studentdetails> p=crepo.findAll(PageRequest.of(pageNu, pageSize, Sort.by(pname).descending()));
		return p.getContent();
	}




}

