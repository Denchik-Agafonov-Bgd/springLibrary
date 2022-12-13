package ru.agafonov.spring.library.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Person {

    private int id;

    @NotEmpty(message = "Name should be not empty")
    @Pattern(regexp = "[A-Z]\\w+ [A-Z]\\w+ [A-Z]\\w+", message = "not valid name")
    private String fio;

    @Min(value = 1900, message = "Age should be greater than 1900")
    @Max(value = 2022, message = "Age should not be max than 2022")
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
