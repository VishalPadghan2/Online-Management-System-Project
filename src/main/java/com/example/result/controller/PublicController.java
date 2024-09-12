package com.example.result.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.result.entity.Marksheet;
import com.example.result.entity.MarksheetDetails;
import com.example.result.entity.Student;
import com.example.result.entity.Subject;
import com.example.result.repo.MarksheetDetailsRepo;
import com.example.result.repo.MarksheetRepo;
import com.example.result.repo.StudentRepo;
import com.example.result.repo.SubjectRepo;

@Controller
@RequestMapping("/public/")
public class PublicController {
	
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	SubjectRepo subjectRepo;
	@Autowired
	MarksheetRepo marksheetRepo;
	@Autowired
	MarksheetDetailsRepo marksheetDetailsRepo;
	
	@GetMapping("/")
	public String homePage()
	{
		return "home";
	}
	
	@PostMapping("/find/")
	public String findMarksheet(String seatNo, String motherName, Model model) 
	{
	  String page = "home"; 
	  Student student	= studentRepo.findBySeatNoAndMotherName(seatNo, motherName);
	  if(student == null)
	  {
		  model.addAttribute("msg", "No student found with seat number" + " " + seatNo + " " + "and mother Name" + " " + motherName);
	  }
	  else
	  {
		  model.addAttribute("student", student);
			
		  List<Subject> listSubject = subjectRepo.findAll();
		  model.addAttribute("listSubject", listSubject);
			
		  Marksheet	marksheetSaved =marksheetRepo.findOneByIdStudent(student.getId());
			  
		  if(marksheetSaved != null)
		  {
			  List<MarksheetDetails> listMarksheetDet = marksheetDetailsRepo.findByIdMarksheet(marksheetSaved.getId());
			  model.addAttribute("listMarksheetDet", listMarksheetDet);
			  model.addAttribute("subjectRepo", subjectRepo);
		  }
		  page="marksheetPublic";
	  }
		return page;
	}
}
