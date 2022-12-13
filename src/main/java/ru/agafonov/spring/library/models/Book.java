package ru.agafonov.spring.library.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Book {
    private int id;
    private int person_id;
    @NotEmpty(message = "Name should be not empty")
    private String name;
    @NotEmpty(message = "Author should be not empty")
    @Pattern(regexp = "[A-Z]\\w+ [A-Z]\\w+", message = "not valid author")
    private String author;
    private int year;

    public Book(int id, int person_id, String name, String author, int year) {
        this.id = id;
        this.person_id = person_id;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}