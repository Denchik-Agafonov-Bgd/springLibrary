package ru.agafonov.spring.library.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Book {
    private int id;


    private Integer person_id;

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    @NotEmpty(message = "Поле не должно быть пустым")
    private String name;
    @NotEmpty(message = "Поле не должно быть пустым")
    @Pattern(regexp = "[А-Я][а-я]+ [А-Я][а-я]+", message = "Некорретное имя автора ")
    private String author;
    private int year;

    public Book(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
