package com.zohocrm.service;

import java.util.List;

import com.zohocrm.entities.Contacts;

public interface ContactService {
	
	public void saveContact(Contacts contact);
	public List<Contacts> getAllContacts();
	public Contacts findContactById(long id);

}
