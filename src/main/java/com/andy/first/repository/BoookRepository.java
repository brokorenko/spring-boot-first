package com.andy.first.repository;

import com.andy.first.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BoookRepository extends CrudRepository<Book, Long> {
}
