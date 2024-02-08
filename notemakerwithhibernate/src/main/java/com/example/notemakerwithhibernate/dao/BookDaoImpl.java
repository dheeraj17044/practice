package com.example.notemakerwithhibernate.dao;

import com.example.notemakerwithhibernate.entity.Book;
import com.example.notemakerwithhibernate.utility.SessionFactoryHelper;
import com.example.notemakerwithhibernate.utility.SessionHelper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
public class BookDaoImpl {

    public void saveBook(Book dbBook) {

        Session session = SessionHelper.getSession();
        Transaction tx = session.beginTransaction();

        session.save(dbBook);

        tx.commit();
        session.close();
    }

    public Book getBook(int bookId) {
        Session session = SessionHelper.getSession();

        Book dbBook = (Book) session.get(Book.class,bookId);

        session.close();

        return dbBook;
    }

    public void saveUpdatedBook(Book dbBook) {
        Session session = SessionHelper.getSession();

        Transaction tx = session.beginTransaction();

        session.update(dbBook);
        tx.commit();
        session.close();
    }

    public void deleteBook(int bookId) {
        Session session = SessionHelper.getSession();

        Transaction tx = session.beginTransaction();

        Book dbBook = (Book) session.get(Book.class,bookId);
        session.delete(dbBook);
        tx.commit();
        session.close();
    }
}
