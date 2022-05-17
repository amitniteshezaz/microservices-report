package com.contact.seervice;

import java.util.List;

import com.contact.entity.Contacts;

public interface ContactService {
	public List<Contacts> getContactsOfUser(Long userId);

}
