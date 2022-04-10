package ru.hh.school.hhVacanciesDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Snippet {

    public String requirement;
    public String responsibility;

    public Snippet(@JsonProperty("requirement") String requirement,
                   @JsonProperty("responsibility") String responsibility) {
        this.requirement = requirement;
        this.responsibility = responsibility;
    }

}
