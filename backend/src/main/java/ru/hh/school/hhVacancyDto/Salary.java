package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Salary {

    public Integer to;
    public Integer from;
    public String currency;
    public Boolean gross;

    public Salary(@JsonProperty("to") Integer to,
                  @JsonProperty("from") Integer from,
                  @JsonProperty("currency") String currency,
                  @JsonProperty("gross") Boolean gross) {
        this.to = to;
        this.from = from;
        this.currency = currency;
        this.gross = gross;
    }

}