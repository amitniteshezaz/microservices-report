package spring.books.Springbooks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import spring.books.Springbooks.model.Book;
import spring.books.Springbooks.repo.BookRepo;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepo repo;
	
private final RestTemplate restTemplate;

	public BookServiceImpl(RestTemplate restTemplate) {
	super();
	this.restTemplate = restTemplate;
}
	
	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	@Override
	public Book addBook(Book book) {
		// TODO Auto-generated method stub
		return repo.save(book);
	}
	@Override
	public Book getBookById(String bookId) {
		// TODO Auto-generated method stub
		return repo.getOne(Integer.parseInt(bookId));
	}
	@Override
	public void deleteBookById(String bookId) {
		// TODO Auto-generated method stub
		Book entity = repo.getOne(Integer.parseInt(bookId));
		repo.delete(entity);
	}
	
	//External Api calling 
	public String consumeApi() {
		return restTemplate.getForObject("http://dummy.restapiexample.com/api/v1/employees",String.class);
	}

	@Override
	public Book getBookByName(String book_name) {
		// TODO Auto-generated method stub
		return repo.getBookByName(book_name);
	}

}
