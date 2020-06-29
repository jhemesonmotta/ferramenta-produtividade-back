package com.jhemeson.ferramentaprodutividadeback.repository;

import com.jhemeson.ferramentaprodutividadeback.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
