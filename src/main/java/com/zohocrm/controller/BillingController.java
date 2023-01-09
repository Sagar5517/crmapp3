package com.zohocrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zohocrm.entities.Billing;
import com.zohocrm.entities.Contacts;
import com.zohocrm.service.BillingService;
import com.zohocrm.service.ContactService;

@Controller
public class BillingController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private BillingService billingService;

	@RequestMapping("billingform")
	public String viewBillingForm(@RequestParam("id") long id,Model model) {
		Contacts contact = contactService.findContactById(id);
		model.addAttribute("contact", contact);
	return "create_bill";	
	}
	
	@RequestMapping("/generateBill")
	public String generateBill(@ModelAttribute("billing")Billing billing, Model model) {
		billingService.generateInvoice(billing);
		model.addAttribute("billing", billing);
		return "list_bills";	
		
		
	}
}
