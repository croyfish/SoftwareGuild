/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.publishing.dao;

import com.sg.publishing.model.Author;
import com.sg.publishing.model.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author jeffc
 */
public class BookDao {
    
    private static String SQL_LIST_BOOKS_BY_AUTHOR = "select b.* from b " +
                                                    "inner join author_book ab ON ab.book_id = b.id " +
                                                    "where ab.author_id = ? limit ?, ?";
    private JdbcTemplate jdbcTemplate;      
    
    public Book get(Integer id) {return null;}
    public void update(Book book) {}
    public void delete(Book book) {}
    public Book create(Book book) {return null;}
    public List<Book> list() {return null;}
    
    public List<Book> getBooksByAuthor(Author author, int offset, int limit) {
        return jdbcTemplate.query(SQL_LIST_BOOKS_BY_AUTHOR,
                new BookMapper(),
                author.getId(),
                offset,
                limit);
    }
    
    private static final class BookMapper implements RowMapper<Book> {

        @Override
        public Book mapRow(ResultSet rs, int i) throws SQLException {
            Book b = new Book();
            b.setName(rs.getString("name"));
            b.setId(rs.getInt("id"));
            return b;
        }
    }       
    
}
