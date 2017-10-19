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
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jeffc
 */
public class AuthorDao {
    
    private static String SQL_INSERT_AUTHOR = "INSERT into author (name) VALUES (?);";
    private static String SQL_GET_AUTHOR = "SELECT * from author where id = ?";
    private static String SQL_UPDATE_AUTHOR = "UPDATE author set name = ? WHERE id = ?";
    private static String SQL_DELETE_AUTHOR = "DELETE FROM author where id = ?";
    private static String SQL_LIST_AUTHORS = "SELECT * from author";
    private static String SQL_LIST_AUTHORS_BY_BOOK = "SELECT author.* from author \n" +
                        "inner join author_book \n" +
                        "on author.authorid = author_book.authorid \n" +
                        "where author_book.bookid = ?"
                        + "limit ?, ?;";

    
    
    private JdbcTemplate jdbcTemplate;

    public Author get(Integer id) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_AUTHOR,
                    new AuthorMapper(),
                    id);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
       
    public void update(Author author) {
        jdbcTemplate.update(SQL_UPDATE_AUTHOR,
            author.getName(), author.getId());
    
    }

    public void deleteAuthor(Author author) {
        jdbcTemplate.update(SQL_DELETE_AUTHOR, author.getId());
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public Author create(Author author) {

        jdbcTemplate.update(SQL_INSERT_AUTHOR,
                author.getName());

        int authorId
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);

        author.setId(authorId);
        
        return author;
    }
    
    public List<Author> list() {
        return jdbcTemplate.query(SQL_LIST_AUTHORS,
                new AuthorMapper());
    }
    
    public List<Author> getAuthorsByBook(Book book, int offset, int limit) {
        return jdbcTemplate.query(SQL_LIST_AUTHORS_BY_BOOK,
                new AuthorMapper(),
                book.getId(),
                offset,
                limit);
    }    
    
    
    private static final class AuthorMapper implements RowMapper<Author> {

        @Override
        public Author mapRow(ResultSet rs, int i) throws SQLException {
            Author au = new Author();
            au.setName(rs.getString("name"));
            au.setId(rs.getInt("id"));
            return au;
        }
    }    
    
}
