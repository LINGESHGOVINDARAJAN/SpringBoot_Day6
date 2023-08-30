package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ChildModel;
import com.example.demo.service.ChildService;

@RestController
public class ChildController {

	@Autowired
	ChildService cs;
	
	@PostMapping("addchild")
	public List<ChildModel> add(@RequestBody List<ChildModel> ss)
	{
		return cs.saveinfo(ss);
	}
	
	@GetMapping("showchild")
	public List<ChildModel> show()
	{
		return cs.showinfo();
	}
	
	@GetMapping("show/{babyId}")
	public Optional<ChildModel> showparent(@PathVariable int babyId)
	{
		return cs.getbyid(babyId);
	}
	
	@GetMapping("sort/{firstname}")
	public List<ChildModel> getsortinfo(@PathVariable String firstname)
	{
		return cs.sortinfo(firstname);
	}
	
	@GetMapping("paging/{pageno}/{pagesize}")
	public List<ChildModel> showpageinfo(@PathVariable int pageno, @PathVariable int pagesize )
	{
		return cs.getbypage(pageno, pagesize);
	}
}
