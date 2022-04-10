package ru.hh.school.hhEmployerDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HhIndustryDto {
    public String id;
    public String name;

    public HhIndustryDto(@JsonProperty("id") String id,
                         @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
