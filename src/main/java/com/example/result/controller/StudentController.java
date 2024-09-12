package com.example.result.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.result.entity.Student;
import com.example.result.repo.StudentRepo;

@Controller
@RequestMapping("/admin/students/")
public class StudentController {
	
	@Autowired
	StudentRepo studentRepo;
	
	@GetMapping("/")
	public String showStudent(Model model)
	{
		List<Student> list= studentRepo.findAll();
		model.addAttribute("list", list);
		return "student";
	}
	
	@PostMapping("/save/")
	public String saveStudent(Student student )
	{
		studentRepo.save(student);
		return "redirect:/admin/students/";
	}
	
	@GetMapping("/delete/{id}/")
	public String deleteStudent(@PathVariable Long id)
	{
		studentRepo.deleteById(id);
		return "redirect:/admin/students/";
	}


}
