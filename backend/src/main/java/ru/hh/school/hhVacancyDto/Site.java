package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Site {
    public String id;
    public String name;

    public Site(@JsonProperty("id") String id,
                @JsonProperty("name") String name){
        this.id = id;
        this.name = name;
    }
}
