package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KeySkill {

    public String name;

    public KeySkill(@JsonProperty("name") String name) {
        this.name = name;
    }

}