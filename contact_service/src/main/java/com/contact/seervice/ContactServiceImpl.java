package com.contact.seervice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.contact.entity.Contacts;

@Service
public class ContactServiceImpl implements ContactService{

	List<Contacts> list=List.of(new Contacts(1L,"amit@gmail.com","Amit",133L),
			new Contacts(2L,"sumit@gmail.com","sumit",1338L)
			);
	
	
	@Override
	public List<Contacts> getContactsOfUser(Long userId) {
		// TODO Auto-generated method stub
		return list.stream().filter(contact->contact.getUserId().equals(userId)).collect(Collectors.toList());
	}

}
