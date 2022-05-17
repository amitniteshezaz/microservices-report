package spring.books.Springbooks.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import spring.books.Springbooks.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Integer>{
	@Query("Select b from Book b where b.book_name=:c")
	public Book getBookByName(@Param("c") String book_name);

}
