package ru.hh.school.hhEmployerDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HhInsiderInterviewDto {
    public String url;
    public String id;
    public String title;

    public HhInsiderInterviewDto(@JsonProperty("url") String url,
                                 @JsonProperty("id") String id,
                                 @JsonProperty("title") String title) {
        this.url = url;
        this.id = id;
        this.title = title;
    }
}
