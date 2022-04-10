package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Schedule {

    public String id;
    public String name;

    public Schedule(@JsonProperty("id") String id,
                    @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

}
