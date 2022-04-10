package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProfessionalRole {

    public String id;
    public String name;

    public ProfessionalRole(@JsonProperty("id") String id,
                            @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

}
