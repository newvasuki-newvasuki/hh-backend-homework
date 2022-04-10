package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LogoUrls {

    public String _90;
    public String _240;
    public String original;

    public LogoUrls(@JsonProperty("90") String _90,
                    @JsonProperty("240") String _240,
                    @JsonProperty("original") String original) {
        this._90 = _90;
        this._240 = _240;
        this.original = original;
    }

}