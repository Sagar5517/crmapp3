package com.zohocrm.service;

import java.util.List;

import com.zohocrm.entities.Lead;

public interface LeadService {
	
	public void saveLead(Lead lead);
	public List<Lead> getAllLeads();
	public Lead findLeadById(long id);
	public void deleteOneLead(long id);

}
