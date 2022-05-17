package spring.books.Springbooks.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Book {
	@Id
	private int book_id;
	private String book_name;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JsonManagedReference
	private Author author;

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public Author getAuthor() {
		return author;
	}

	public Author setAuthor(Author author) {
		return this.author = author;
	}

	public Book(int book_id, String book_name, Author author) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.author = author;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_name=" + book_name + ", author=" + author + "]";
	}
	
	

}
