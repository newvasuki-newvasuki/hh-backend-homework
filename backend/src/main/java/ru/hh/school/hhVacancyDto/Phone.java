package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Phone {

    public String country;
    public String city;
    public String number;
    public Object comment;

    public Phone(@JsonProperty("country") String country,
                 @JsonProperty("city") String city,
                 @JsonProperty("number") String number,
                 @JsonProperty("comment") Object comment) {
        this.country = country;
        this.city = city;
        this.number = number;
        this.comment = comment;
    }

}
