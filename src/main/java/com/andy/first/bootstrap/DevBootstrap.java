package com.andy.first.bootstrap;

import com.andy.first.model.Author;
import com.andy.first.model.Book;
import com.andy.first.model.Publisher;
import com.andy.first.repository.AuthorRepository;
import com.andy.first.repository.BookRepository;
import com.andy.first.repository.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher collins = new Publisher("Collins corp", "dry street");
        publisherRepository.save(collins);

        Author bob = new Author("Bob", "Robbins");
        Book bbb = new Book("DDD", "1233", collins);
        bob.getBooks().add(bbb);
        bbb.getAuthors().add(bob);

        authorRepository.save(bob);
        bookRepository.save(bbb);

        Author rob = new Author("Rob", "Biblson");
        Book ggg = new Book("GGG", "9090", collins);
        rob.getBooks().add(ggg);
        bbb.getAuthors().add(rob);

        authorRepository.save(rob);
        bookRepository.save(ggg);
    }
}
