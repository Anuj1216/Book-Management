package com.anuj.bookmanagement.services;

import com.anuj.bookmanagement.entities.Book;
import com.anuj.bookmanagement.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Book getBookById(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book Not Found!"));
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Book book, Long id){
        Book oldBook = bookRepository.findById(id).orElseThrow(() -> new  RuntimeException("Book Not Found!"));

        oldBook.setTitle(book.getTitle());
        oldBook.setAuthor(book.getAuthor());
        oldBook.setGenre(book.getGenre());

        return bookRepository.save(oldBook);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }
}
