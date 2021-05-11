package hr.pejak.gurufirsttutorial.repositories;

import hr.pejak.gurufirsttutorial.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
