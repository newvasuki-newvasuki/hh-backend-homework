package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DriverLicenseType {

    public String id;

    public DriverLicenseType(@JsonProperty("id") String id) {
        this.id = id;
    }

}

