/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.publishing.service;

import com.sg.publishing.dao.AuthorDao;
import com.sg.publishing.dao.Author_BookDao;
import com.sg.publishing.dao.BookDao;
import com.sg.publishing.model.Author;
import com.sg.publishing.model.Author_Book;
import com.sg.publishing.model.Book;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class AuthorService {
    
    AuthorDao authorDao;
    BookDao bookDao;
    Author_BookDao authorBookDao;
    
    public List<Author> getAuthorByBook(Book book, int offset, int limit) {
        return authorDao.getAuthorsByBook(book, offset, limit);
    }
    
    public Author_Book addAuthorToBook(Author author, Book book) {

        Author_Book ab = new Author_Book();
        ab.setAuthor(author);
        ab.setBook(book);
        
        return authorBookDao.create(ab);
    };
    
    public Author_Book addAuthorToBook(int authorId, int bookId) {

        Author author = authorDao.get(authorId);
        Book book = bookDao.get(bookId);
        return addAuthorToBook(author, book);
    };    
    
    
    
}
