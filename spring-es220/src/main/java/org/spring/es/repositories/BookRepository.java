package org.spring.es.repositories;

import org.spring.es.bean.Book;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by yemengying on 16/1/10.
 */
public interface BookRepository extends CrudRepository<Book, String> {

    List<Book> findByName(String name);

    List<Book> findByPrice(double price);

}
