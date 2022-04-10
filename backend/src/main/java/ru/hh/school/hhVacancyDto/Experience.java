package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Experience {

    public String id;
    public String name;

    public Experience(@JsonProperty("id") String id,
                      @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

}
