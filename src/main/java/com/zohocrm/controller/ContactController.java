package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Contacts;
import com.zohocrm.entities.Lead;
import com.zohocrm.service.ContactService;

@Controller
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	
	@RequestMapping("/listcontacts")
	public String listAllContacts(Model model) {
		List<Contacts> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_contact";
		
		
		
	}
	@RequestMapping("/contactinfo")
	public String contactInfo(@RequestParam("id") long id,Model model) {
		Contacts contact=contactService.findContactById(id);
		model.addAttribute("contact", contact);
		return "contact_info";
	}
}
