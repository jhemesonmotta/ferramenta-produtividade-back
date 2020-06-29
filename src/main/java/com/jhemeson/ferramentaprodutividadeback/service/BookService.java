package com.jhemeson.ferramentaprodutividadeback.service;

import com.jhemeson.ferramentaprodutividadeback.dto.MessageResponseDTO;
import com.jhemeson.ferramentaprodutividadeback.entity.Book;
import com.jhemeson.ferramentaprodutividadeback.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public MessageResponseDTO create(Book book) {
        Book savedBook = bookRepository.save(book);
        return MessageResponseDTO.builder().
                message("Book created with id: " + savedBook.getId())
                .build();
    }
}
