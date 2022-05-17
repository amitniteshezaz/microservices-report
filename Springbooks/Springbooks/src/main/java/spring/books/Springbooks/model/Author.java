package spring.books.Springbooks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity

public class Author {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@javax.persistence.Id
	private int Id;
	private String firstName;
	private String lastName;
	private String language;
	
	@OneToOne(mappedBy = "author")
	@JsonBackReference
private Book book;
	

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Author(int id, String firstName, String lastName, String language) {
		super();
		Id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.language = language;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Author [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", language=" + language
				+ "]";
	}
	

}
