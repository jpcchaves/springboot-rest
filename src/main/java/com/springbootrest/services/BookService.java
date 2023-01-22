package com.springbootrest.services;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.springbootrest.controllers.BookController;
import com.springbootrest.controllers.PersonController;
import com.springbootrest.data.vo.v1.BookVO;
import com.springbootrest.exceptions.ResourceNotFoundException;
import com.springbootrest.mapper.DozerMapper;
import com.springbootrest.mapper.custom.PersonMapper;
import com.springbootrest.model.Book;
import com.springbootrest.repositories.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookService {

  @Autowired
  BookRepository bookRepository;

  @Autowired
  PersonMapper mapper;

  public List<BookVO> findAll() {
    var books = DozerMapper.parseListObjects(bookRepository.findAll(), BookVO.class);

    books.stream().forEach(
        p -> {
          try {
            p.add(linkTo(methodOn(BookController.class).findById(p.getKey())).withSelfRel());
          } catch (Exception e) {
            throw new RuntimeException(e);
          }
        });

    return books;
  }

  public BookVO findById(Long id) throws Exception {

    var entity = bookRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Não foi encontrado um livro com o ID informado."));

    var vo = DozerMapper.parseObject(entity, BookVO.class);

    vo.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());

    return vo;
  }

  public BookVO createBook(BookVO book) throws Exception {
    var entity = DozerMapper.parseObject(book, Book.class);
    var vo = DozerMapper.parseObject(bookRepository.save(entity), BookVO.class);
    vo.add(linkTo(methodOn(BookController.class).findById(vo.getKey())).withSelfRel());
    return vo;
  }

  public BookVO updateBook(BookVO book) {

    var entity = bookRepository.findById(book.getKey())
        .orElseThrow(() -> new ResourceNotFoundException(
            "Não foi encontrado um livro com o ID informado."));

    entity.setAuthor(book.getAuthor());
    entity.setLaunchDate(book.getLaunchDate());
    entity.setPrice(book.getPrice());
    entity.setTitle(book.getTitle());

    var vo = DozerMapper.parseObject(bookRepository.save(entity), BookVO.class);

    return vo;
  }

  public void deleteBook(Long id) {

    var entity = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(
        "Não foi possível deletar o livro porque o ID informado não foi encontrado"));

    bookRepository.delete(entity);

  }

}
