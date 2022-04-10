package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Contacts {

    public String name;
    public String email;
    public List<Phone> phones = null;

    public Contacts(@JsonProperty("name") String name,
                    @JsonProperty("email") String email,
                    @JsonProperty("phones") List<Phone> phones) {
        this.name = name;
        this.email = email;
        this.phones = phones;
    }

}
