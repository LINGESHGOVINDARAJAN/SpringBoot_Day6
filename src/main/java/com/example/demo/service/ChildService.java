package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.ChildModel;
import com.example.demo.repository.ChildRepo;

@Service
public class ChildService {

	@Autowired
	ChildRepo cr;
	
	public List<ChildModel> saveinfo(List<ChildModel> ss)
	{
		return (List<ChildModel>)cr.saveAll(ss);
	}
	
	public List<ChildModel> showinfo()
	{
		return cr.findAll();
	}
	
	public ChildModel changeinfo(ChildModel ss)
	{
		return cr.saveAndFlush(ss);
	}
	
	public void delete(ChildModel ss)
	{
		cr.delete(ss);
	}
	
	public Optional<ChildModel> getbyid(int id)
	{
		return cr.findById(id);
	}
	
	public List<ChildModel> sortinfo(String s)
	{
		return cr.findAll(Sort.by(Sort.DEFAULT_DIRECTION,s));
	}
	
	public List<ChildModel> getbypage(int pgno,int pgsize)
	{
		Page<ChildModel> p=cr.findAll(PageRequest.of(pgno, pgsize));
		return p.getContent();
	}
}
