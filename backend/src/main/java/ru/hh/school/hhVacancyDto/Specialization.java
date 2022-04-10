package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Specialization {

    public String profareaId;
    public String profareaName;
    public String id;
    public String name;

    public Specialization(@JsonProperty("profarea_id") String profareaId,
                          @JsonProperty("profarea_name") String profareaName,
                          @JsonProperty("id") String id,
                          @JsonProperty("name") String name) {
        this.profareaId = profareaId;
        this.profareaName = profareaName;
        this.id = id;
        this.name = name;
    }

}
