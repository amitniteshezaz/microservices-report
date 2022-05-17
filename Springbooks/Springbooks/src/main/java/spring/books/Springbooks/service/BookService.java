package spring.books.Springbooks.service;

import java.util.List;

import spring.books.Springbooks.model.Book;

public interface BookService {

	public List<Book> getBooks();

	public Book addBook(Book book);

	public Book getBookById(String bookId);

	public void deleteBookById(String bookId);
	public String consumeApi();

	public Book getBookByName(String book_name);
	

}
