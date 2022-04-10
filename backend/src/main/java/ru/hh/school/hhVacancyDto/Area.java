package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Area {

    private String url;
    private String id;
    private String name;

    public Area(@JsonProperty("url") String url,
                @JsonProperty("id") String id,
                @JsonProperty("name") String name) {
        this.url = url;
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return Long.parseLong(id);
    }

    public String getName() {
        return name;
    }
}
