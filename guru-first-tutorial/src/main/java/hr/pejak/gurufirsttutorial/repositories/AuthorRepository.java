package hr.pejak.gurufirsttutorial.repositories;

import hr.pejak.gurufirsttutorial.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {


}
