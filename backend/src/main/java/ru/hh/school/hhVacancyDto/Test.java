package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Test {

    public Boolean required;

    public Test(@JsonProperty("required") Boolean required) {
        this.required = required;
    }

}