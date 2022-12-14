package ru.agafonov.spring.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.agafonov.spring.library.models.Book;
import ru.agafonov.spring.library.models.Person;

import java.util.List;
import java.util.Optional;

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

    public Person bookAndPerson(int id) {
        return jdbcTemplate.query("SELECT Person.* FROM Book JOIN Person ON Book.person_id=Person.id WHERE Book.id=?", new Object[]{id},
                new BeanPropertyRowMapper<>(Person.class)).stream().findAny().orElse(null);
    }

    public void releaseBook(int id) {
        jdbcTemplate.update("UPDATE Book SET person_id=null WHERE id=?", id);
    }

    public void assign(int id, Person person) {
        jdbcTemplate.update("UPDATE Book SET person_id=? WHERE id=?",person.getId(), id);
    }
}
