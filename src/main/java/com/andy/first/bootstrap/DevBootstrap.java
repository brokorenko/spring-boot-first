package com.andy.first.bootstrap;

import com.andy.first.model.Author;
import com.andy.first.model.Book;
import com.andy.first.repository.AuthorRepository;
import com.andy.first.repository.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author bob = new Author("Bob", "Robbins");
        Book bbb = new Book("DDD", "1233", "Collins corp");
        bob.getBooks().add(bbb);
        bbb.getAuthors().add(bob);

        authorRepository.save(bob);
        bookRepository.save(bbb);

        Author rob = new Author("Rob", "Biblson");
        Book ggg = new Book("GGG", "9090", "Sistem corp");
        rob.getBooks().add(ggg);
        bbb.getAuthors().add(rob);

        authorRepository.save(rob);
        bookRepository.save(ggg);
    }
}
