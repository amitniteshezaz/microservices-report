package com.contact.entity;

public class Contacts {
	
	private Long contactId;
	private String contactemail;
	private String contactname;
	private Long userId;
	public Contacts(Long contactId, String contactemail, String contactname, Long userId) {
		super();
		this.contactId = contactId;
		this.contactemail = contactemail;
		this.contactname = contactname;
		this.userId = userId;
	}
	
	public Contacts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getContactId() {
		return contactId;
	}
	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}
	public String getContactemail() {
		return contactemail;
	}
	public void setContactemail(String contactemail) {
		this.contactemail = contactemail;
	}
	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	
	

}
