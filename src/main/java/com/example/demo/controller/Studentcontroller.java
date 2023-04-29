package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Studentdetails;
import com.example.demo.service.studentservice;

@RestController
public class Studentcontroller {


@Autowired
public studentservice cServ;
@PostMapping("/post")
public Studentdetails addDetails(@RequestBody Studentdetails sm)
{
	return cServ.saveDetails(sm);
}
@GetMapping("/getdb")
public List<Studentdetails>getDetails()
{
	return cServ.getDetails();
}
@PutMapping("/put")
public Studentdetails update(@RequestBody Studentdetails id)
{
	return cServ.updateDetails(id);
}
@DeleteMapping("/delete/{id}")
public String deleteDetails(@PathVariable("id") int hid)
{
	cServ.deleteDetails(hid);
	return "deleted";
}
@DeleteMapping("/deletes")
public String deleteBypara(@RequestParam ("id") int id )
{
	cServ.deleteDetails(id);
	return id+" is deleted";
}
//sort
@GetMapping("/sortAsc/{brand}")
public List<Studentdetails> sortStudent(@PathVariable("brand")String name)
{
	  return cServ.sortAsc(name);
}

//pagination
@GetMapping("/pagi/{pnu}/{psize}")
public List<Studentdetails> paginationData(@PathVariable("pnu") int pnu, @PathVariable("psize") int psize)
{
	  return cServ.paginationAndSorting(pnu, psize);
}

//pagination and sorting
@GetMapping("/paginationSorting/{pnu}/{psize}/{pname}")
public List<Studentdetails> paginationSorting(@PathVariable("pnu") int pnu, @PathVariable("psize") int psize, @PathVariable("pname") String pname)
{
	  return cServ.paginationAndSorting(pnu, psize, pname);
}

}