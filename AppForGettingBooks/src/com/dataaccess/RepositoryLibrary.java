/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dataaccess;

import com.classes.Book;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author valentina
 */
public class RepositoryLibrary {
    public static List<Book> getAllBooks() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("AppForGettingBooksPU");
            EntityManager em = emf.createEntityManager();
            StoredProcedureQuery query = em.createStoredProcedureQuery("BOOKS_TAPI.get_books")
                    .registerStoredProcedureParameter(
                            0,
                            String.class,
                            ParameterMode.REF_CURSOR
                    );
    query.execute();

    List<Object[]> booksObj = query.getResultList();
    List<Book> books = new ArrayList<>();
    for (Object[] b : booksObj) {
        Book book = new Book();
        book.setTitle(b[0].toString());
        book.setAuthorFirstName(b[1].toString());
        book.setAuthorLastName(b[2].toString());
        book.setRating(Integer.parseInt(b[3].toString()));
        books.add(book);
    }
    return books;

    }
}
