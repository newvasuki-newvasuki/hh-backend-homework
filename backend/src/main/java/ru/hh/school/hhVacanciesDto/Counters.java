package ru.hh.school.hhVacanciesDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Counters {
    public Integer responses;

    public Counters(@JsonProperty("responses") Integer responses){
        this.responses = responses;
    }
}
