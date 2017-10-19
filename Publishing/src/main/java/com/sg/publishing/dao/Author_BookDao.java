/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.publishing.dao;

import com.sg.publishing.model.Author;
import com.sg.publishing.model.Author_Book;
import com.sg.publishing.model.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jeffc
 */
public class Author_BookDao {
    
    private JdbcTemplate jdbcTemplate;    
    
    private static String SQL_INSERT_AUTHOR_BOOK = "INSERT into author_book (author_id, book_id) VALUES (? ?);";
    private static String SQL_GET_AUTHOR_BOOK = "SELECT * from author_book where id = ?";
    private static String SQL_UPDATE_AUTHOR_BOOK = "UPDATE author_book set author_id = ?, set book_id = ? WHERE id = ?";
    private static String SQL_DELETE_AUTHOR_BOOK = "DELETE FROM author_book where id = ?";
    private static String SQL_LIST_AUTHORS_BOOKS = "SELECT * from author_book";    
    
    
    public Author_Book get(Integer id) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_AUTHOR_BOOK,
                    new Author_BookDao.Author_BookMapper(),
                    id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }    
    }
    
    public void update(Author_Book authorBook) {
        
        if (authorBook.getAuthor() == null) return;
        if (authorBook.getBook() == null) return;
        
        jdbcTemplate.update(SQL_UPDATE_AUTHOR_BOOK, authorBook.getAuthor(), authorBook.getBook());    
    }
    
    public void delete(Author_Book authorBook) {
            jdbcTemplate.update(SQL_DELETE_AUTHOR_BOOK, authorBook.getId());
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Author_Book create(Author_Book authorBook) {    

        jdbcTemplate.update(SQL_INSERT_AUTHOR_BOOK,
                authorBook.getAuthor().getId(),
                authorBook.getBook().getId());

        int authorBookId
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);

        authorBook.setId(authorBookId);
        
        return authorBook;
    
    }
    
    public List<Author_Book> list() {
        return jdbcTemplate.query(SQL_LIST_AUTHORS_BOOKS,
                new Author_BookDao.Author_BookMapper());    
    
    }
    
    private static final class Author_BookMapper implements RowMapper<Author_Book> {

        @Override
        public Author_Book mapRow(ResultSet rs, int i) throws SQLException {
            
            Author_Book ab = new Author_Book();
            
            //Lazy load author
            Author author = new Author();
            author.setId(rs.getInt("author_id"));
            
            //Lazy load book
            Book book = new Book();
            book.setId(rs.getInt("book_id"));
            
            ab.setId(rs.getInt("id"));
            
            return ab;
        }
    }      
    
}
