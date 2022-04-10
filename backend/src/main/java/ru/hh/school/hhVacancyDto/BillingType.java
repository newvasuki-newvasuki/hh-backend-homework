package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BillingType {

    public String id;
    public String name;

    public BillingType(@JsonProperty("id") String id,
                       @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

}
