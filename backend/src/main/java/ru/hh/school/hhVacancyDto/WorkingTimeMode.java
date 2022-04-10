package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkingTimeMode {

    public String id;
    public String name;

    public WorkingTimeMode(@JsonProperty("id") String id,
                           @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

}
