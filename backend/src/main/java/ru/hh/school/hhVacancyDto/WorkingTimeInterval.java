package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WorkingTimeInterval {

    public String id;
    public String name;

    public WorkingTimeInterval(@JsonProperty("id") String id,
                               @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

}
