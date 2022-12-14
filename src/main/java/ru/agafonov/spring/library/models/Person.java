package ru.agafonov.spring.library.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Person {

    private int id;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Pattern(regexp = "[А-Я][а-я]+ [А-Я][а-я]+ [А-Я][а-я]+", message = "Некорректное имя")
    private String fio;

    @Min(value = 1900, message = "Дата рождения должна быть позже 1900 года")
    @Max(value = 2022, message = "Дата рождения должна быть раньше 2023 года")
    private int birthday;

    public Person(){}

    public Person(int id, String fio, int birthday) {
        this.id = id;
        this.fio = fio;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }
}
