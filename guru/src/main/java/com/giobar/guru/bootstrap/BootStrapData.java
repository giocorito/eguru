package com.giobar.guru.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.giobar.guru.domain.Author;
import com.giobar.guru.domain.Book;
import com.giobar.guru.domain.Publisher;
import com.giobar.guru.repository.AuthorRepository;
import com.giobar.guru.repository.BookRepository;
import com.giobar.guru.repository.PublisherRepository;

@Component
public class BootStrapData implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
			PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Publisher feltri = new Publisher("La Feltrinelli", "Via Po'", "Torino", "IT", "15100");

		publisherRepository.save(feltri);

		Author andrea = new Author("Andrea", "Camilleri");
		Book mossa = new Book("La mossa del cavallo", "4985734698");
		andrea.getBooks().add(mossa);
		mossa.getAuthors().add(andrea);
		mossa.setPublisher(feltri);
		feltri.getBooks().add(mossa);

		authorRepository.save(andrea);
		bookRepository.save(mossa);

		Author alex = new Author("Alessandro", "Baricco");
		Book novecento = new Book("Novecento", "435346534");
		alex.getBooks().add(novecento);
		novecento.getAuthors().add(alex);

		novecento.setPublisher(feltri);
		feltri.getBooks().add(novecento);

		authorRepository.save(alex);
		bookRepository.save(novecento);

		publisherRepository.save(feltri);

		System.out.println("Spring Data Started");
		System.out.println("Num of books : " + bookRepository.count());
		System.out.println("Publisher num of bokks : " + feltri.getBooks().size());

	}

}
