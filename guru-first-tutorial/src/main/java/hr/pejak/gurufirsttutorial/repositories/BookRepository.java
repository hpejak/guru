package hr.pejak.gurufirsttutorial.repositories;

import hr.pejak.gurufirsttutorial.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
