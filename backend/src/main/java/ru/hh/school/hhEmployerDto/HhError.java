package ru.hh.school.hhEmployerDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HhError {
    private String type;
    public HhError(@JsonProperty("type") String type){
        this.type = type;
    }
}
