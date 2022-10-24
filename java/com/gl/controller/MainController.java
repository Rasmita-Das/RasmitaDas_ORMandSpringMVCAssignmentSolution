package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.entity.Customer;
import com.gl.service.CusSrvc;

@Controller
@RequestMapping("/customer")
public class MainController {
	
	@Autowired
	private CusSrvc cusSrvc;
	
	@RequestMapping("/list")
	public String listStudents(Model model) {
		List<Customer> cus = cusSrvc.findAll();
		model.addAttribute("Customer", cus);

		return "Cus-list";
	}

	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer cus = new Customer();
		theModel.addAttribute("Customer", cus);

		return "Cus-form";
	}

	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("theId") int theId, Model theModel) {
		Customer cus = cusSrvc.findById(theId);
		theModel.addAttribute("Customer", cus);

		return "Cus-form";
	}

	
	@PostMapping("/save")
	public String saveStudent(@RequestParam("id") int id, 
			@RequestParam("fName") String fName,
			@RequestParam("lName") String lName,
			@RequestParam("email") String email) {

		Customer cus;
		
		if (id != 0) {
			cus = cusSrvc.findById(id);
			cus.setfName(fName);
			cus.setlName(lName);
			cus.setEmail(email);
		} else {
			cus = new Customer(fName, lName, email);
		}
		cusSrvc.save(cus);

		return "redirect:/customer/list";
		}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("theId") int theId) {
		cusSrvc.delete(theId);

		return "redirect:/customer/list";
	}

}
