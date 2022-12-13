package ru.agafonov.spring.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.agafonov.spring.library.models.Book;
import ru.agafonov.spring.library.models.Person;

import java.util.List;

@Component
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> index() {
        return jdbcTemplate.query("SELECT * FROM Book order by id", new BeanPropertyRowMapper<>(Book.class));
    }

    public void save(Book book){
        jdbcTemplate.update("INSERT INTO Book(name, author, year) VALUES (?,?,?)", book.getName(), book.getAuthor(), book.getYear());
    }

    public void update(int id, Book updateBook){
        jdbcTemplate.update("UPDATE Book SET name=?, author=?, year=? WHERE id=?", updateBook.getName(), updateBook.getAuthor(), updateBook.getYear(), id);
    }

    public Book show(int id) {
        return jdbcTemplate.query("SELECT * FROM Book WHERE id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Book.class)).stream().findAny().orElse(null);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Book WHERE id=?", id);
    }
}
