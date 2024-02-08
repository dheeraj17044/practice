package com.example.notemakerwithhibernate.controller;

import com.example.notemakerwithhibernate.entity.Book;
import com.example.notemakerwithhibernate.entity.BookRequestDto;
import com.example.notemakerwithhibernate.sevice.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {

    @Autowired
    NoteServiceImpl noteService;

    @PostMapping("/book")
    public ResponseEntity<Object> addBook(@RequestBody BookRequestDto book){
        Book dbBook = noteService.addBook(book);
        return new ResponseEntity<>(dbBook, HttpStatus.OK);
    }

    @GetMapping("/book/id/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable String bookId){
        Book book = noteService.getBook(bookId);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @PutMapping("/book")
    public ResponseEntity<Book> getBook(@RequestBody BookRequestDto bookRequestDto){
        Book book = noteService.updateBook(bookRequestDto);
        return new ResponseEntity<>(book,HttpStatus.OK);
    }

    @DeleteMapping("/book/{bookId}")
    public ResponseEntity<Object> deleteBook(@PathVariable int bookId){
        noteService.deleteBook(bookId);
        return new ResponseEntity<>("deleted",HttpStatus.OK);
    }

}
