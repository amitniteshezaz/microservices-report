package spring.books.Springbooks.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.books.Springbooks.model.Book;
import spring.books.Springbooks.service.BookService;

@RestController
public class BookController {

@Autowired
private BookService service;
	@GetMapping("/book")
	public ResponseEntity<List<Book>> getBooks(){
		List<Book> list=service.getBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
	}
	@PostMapping("/book")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		Book b=null;
		try {
			b=this.service.addBook(book);
			return ResponseEntity.of(Optional.of(b));
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
	}
	@GetMapping("/book/{bookId}")
	public ResponseEntity<Book> getBookById(@PathVariable String bookId) {
		Book book=service.getBookById(bookId);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@DeleteMapping("/book/{bookId}")
	public ResponseEntity<HttpStatus> deleteBookById(@PathVariable String bookId) {
		try {
			this.service.deleteBookById(bookId);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	@GetMapping("/")
	public ResponseEntity<Book> getData() {
		try {
			this.service.consumeApi();
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("book1/{book_name}")
	public ResponseEntity<Book> getBookByName(@PathVariable String book_name){
		Book book=service.getBookByName(book_name);
		if(book_name==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	

}
