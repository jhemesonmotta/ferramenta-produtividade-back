package com.jhemeson.ferramentaprodutividadeback.mapper;

import com.jhemeson.ferramentaprodutividadeback.dto.BookDTO;
import com.jhemeson.ferramentaprodutividadeback.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    Book toModel(BookDTO bookDTO);

    BookDTO toDTO(Book book);
}
