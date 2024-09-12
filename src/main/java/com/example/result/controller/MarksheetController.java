package com.example.result.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.result.entity.Marksheet;
import com.example.result.entity.MarksheetDetails;
import com.example.result.entity.Student;
import com.example.result.entity.Subject;
import com.example.result.repo.MarksheetDetailsRepo;
import com.example.result.repo.MarksheetRepo;
import com.example.result.repo.StudentRepo;
import com.example.result.repo.SubjectRepo;

@Controller
@RequestMapping("/admin/marksheets/")
public class MarksheetController {
	
	@Autowired
	MarksheetRepo marksheetRepo;
	
	@Autowired
	MarksheetDetailsRepo marksheetDetailsRepo;
	
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	SubjectRepo subjectRepo;
	
	@GetMapping("/{idStud}/")
	public String showMarksheet(@PathVariable Long idStud, Model model) 
	{
		Student student = studentRepo.getReferenceById(idStud);
		model.addAttribute("student", student);
		
		List<Subject> listSubject = subjectRepo.findAll();
		model.addAttribute("listSubject", listSubject);
		
		Marksheet	marksheetSaved =marksheetRepo.findOneByIdStudent(idStud);
		  
		  if(marksheetSaved != null)
		  {
			  List<MarksheetDetails> listMarksheetDet = marksheetDetailsRepo.findByIdMarksheet(marksheetSaved.getId());
			  model.addAttribute("listMarksheetDet", listMarksheetDet);
			  model.addAttribute("subjectRepo", subjectRepo);
		  }
		
		return "marksheet";
	}
	
	
	@PostMapping("/save/")
	public String saveMarksheetData(@RequestParam Long idSub, @RequestParam int marks, @RequestParam Long idStud) 
	{
	  Marksheet	marksheetSaved =marksheetRepo.findOneByIdStudent(idStud);
	  
	  if(marksheetSaved == null)
	  {
		  Marksheet marksheet = new Marksheet(idStud);
		  marksheetSaved = marksheetRepo.save(marksheet);
	  }
	  
	  MarksheetDetails marksheetDetSaved = marksheetDetailsRepo.findOneByIdMarksheetAndIdSubject(marksheetSaved.getId(), idSub);
	  if(marksheetDetSaved == null)
	  {
		  MarksheetDetails marksheetDetails = new MarksheetDetails(marksheetSaved.getId(), idSub, marks);
		  marksheetDetailsRepo.save(marksheetDetails);
	  }
	  else
	  {
		  marksheetDetSaved.setMarks(marks);
		  marksheetDetailsRepo.save(marksheetDetSaved);
		  
	  }
	  
		return "redirect:/admin/marksheets/" + idStud + "/";
	}
	
	

}
