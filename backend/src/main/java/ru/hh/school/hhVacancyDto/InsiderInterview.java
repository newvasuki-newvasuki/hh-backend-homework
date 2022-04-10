package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InsiderInterview {

    public String id;
    public String url;

    public InsiderInterview(@JsonProperty("id") String id,
                            @JsonProperty("url") String url) {
        this.id = id;
        this.url = url;
    }

}
