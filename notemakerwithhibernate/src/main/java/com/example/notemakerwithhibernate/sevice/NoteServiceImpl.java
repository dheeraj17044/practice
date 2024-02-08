package com.example.notemakerwithhibernate.sevice;

import com.example.notemakerwithhibernate.dao.BookDaoImpl;
import com.example.notemakerwithhibernate.entity.Book;
import com.example.notemakerwithhibernate.entity.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class NoteServiceImpl {

    @Autowired
    BookDaoImpl bookDao;

    public Book addBook(BookRequestDto book){
        Book dbBook = new Book();
        dbBook.setBookId(book.getBookId());
        dbBook.setBookName(book.getBookName());
        dbBook.setBookAuthor(book.getBookAuthor());
        dbBook.setPages(book.getPages());
        bookDao.saveBook(dbBook);
        return dbBook;
    }

    public Book getBook(String bookId) {
        return bookDao.getBook(Integer.parseInt(bookId));
    }

    public Book updateBook(BookRequestDto bookRequestDto) {
        // Check if the book with the given bookId exists
        Book dbBook = bookDao.getBook(bookRequestDto.getBookId());

        if (dbBook == null) {
            // Handle the case where the book with the given ID doesn't exist
            // Throw an exception, return an error response, or take appropriate action
            // For example:
            throw new EntityNotFoundException("Book with ID " + bookRequestDto.getBookId() + " not found");
        }

        // Modify the existing book
        dbBook.setBookName(bookRequestDto.getBookName());
        dbBook.setPages(bookRequestDto.getPages());
        dbBook.setBookAuthor(bookRequestDto.getBookAuthor());

        // Save the updated book
        bookDao.saveUpdatedBook(dbBook);

        return dbBook;
    }

    public void deleteBook(int bookId) {
        bookDao.deleteBook(bookId);
    }
}
