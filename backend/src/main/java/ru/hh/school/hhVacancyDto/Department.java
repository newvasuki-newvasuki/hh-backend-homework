package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Department {

    public String id;
    public String name;

    public Department(@JsonProperty("id") String id,
                      @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

}
