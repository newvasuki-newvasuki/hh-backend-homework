package ru.hh.school.hhEmployerDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HhAreaDto {
    private  String url;
    private  String id;
    private  String name;

    public HhAreaDto(@JsonProperty("url")   String url,
                     @JsonProperty("id")    String id,
                     @JsonProperty("name")  String name){
        this.url  = url;
        this.id   = id;
        this.name = name;
    }

    public HhAreaDto() {

    }

    public Long getId() {
        return Long.parseLong(id);
    }

    public String getName() {
        return name;
    }
}
