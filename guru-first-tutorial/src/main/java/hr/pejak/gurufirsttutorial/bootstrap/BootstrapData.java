package hr.pejak.gurufirsttutorial.bootstrap;

import hr.pejak.gurufirsttutorial.model.Author;
import hr.pejak.gurufirsttutorial.model.Book;
import hr.pejak.gurufirsttutorial.model.Publisher;
import hr.pejak.gurufirsttutorial.repositories.AuthorRepository;
import hr.pejak.gurufirsttutorial.repositories.BookRepository;
import hr.pejak.gurufirsttutorial.repositories.PublisherRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        var znanje = new Publisher("Znanje","Gajeva","1","Zagreb", "10000");
        publisherRepository.save(znanje);

        log.info("There is {} publisher", publisherRepository.count());

        var lee = new Author("Lee", "Child");
        var oneShot = new Book("One Shot", "12345");
        lee.getBooks().add(oneShot);
        oneShot.getAuthors().add(lee);
        oneShot.setPublisher(znanje);
        znanje.getBooks().add(oneShot);

        authorRepository.save(lee);
        bookRepository.save(oneShot);

        var grisham = new Author("John", "Grisham");
        var sooley = new Book("Sooley", "23456");
        grisham.getBooks().add(sooley);
        sooley.getAuthors().add(grisham);
        sooley.setPublisher(znanje);
        znanje.getBooks().add(sooley);

        authorRepository.save(grisham);
        bookRepository.save(sooley);
        publisherRepository.save(znanje);

        log.info("Bootstrap is started");
        log.info("Number of Books: {}", bookRepository.count());
        log.info("Publisher has {} books", znanje.getBooks().size());
    }
}
