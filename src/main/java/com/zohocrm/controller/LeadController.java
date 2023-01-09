package com.zohocrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Contacts;
import com.zohocrm.entities.Lead;
import com.zohocrm.service.ContactService;
import com.zohocrm.service.LeadService;

@Controller
public class LeadController {
	
	@Autowired
	private LeadService leadService;
	@Autowired
	private ContactService contactService;
	
	
	@RequestMapping("/create")
	public String viewCreateLeadForm() {
		return "create_lead";
		
	}
	
	@RequestMapping("/save")
	public String saveOneLead(@ModelAttribute("lead") Lead lead,Model model) {
		leadService.saveLead(lead);
		model.addAttribute("lead", lead);
		return "lead_info";
		
	}
	
	@RequestMapping("/listleads")
	public String listLeads(Model model) {
		List<Lead> leads = leadService.getAllLeads();
		System.out.println(leads);
		model.addAttribute("leads", leads);
		return "list_leads";
	}
	
	@RequestMapping("/leadinfo")
	public String leadInfo(@RequestParam("id") long id,Model model) {
		Lead lead=leadService.findLeadById(id);
		model.addAttribute("lead", lead);
		return "lead_info";
	}
	
	@RequestMapping("/convert")
	public String convertLead(@RequestParam("id") long id,Model model) {
		Lead lead = leadService.findLeadById(id);
		Contacts contact=new Contacts();
		contact.setFirstName(lead.getFirstName());
		contact.setLastName(lead.getLastName());
		contact.setEmail(lead.getEmail());
		contact.setMobile(lead.getMobile());
		contact.setSource(lead.getSource());
		
		contactService.saveContact(contact);
		
		leadService.deleteOneLead(id);
		
		List<Contacts> contacts = contactService.getAllContacts();
		model.addAttribute("contacts", contacts);
		return "list_contact";
	}
	
	
	

}
