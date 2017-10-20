/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.publishing.service;

import com.sg.publishing.dao.BookDao;
import com.sg.publishing.model.Author;
import com.sg.publishing.model.Book;
import java.util.List;

/**
 *
 * @author jeffc
 */
public class BookService {

    BookDao bookDao;
    
    public List<Book> getBooksByAuthor(Author author, int offset, int limit) {
        return bookDao.getBooksByAuthor(author, offset, limit);
    }
    
}
