package ru.hh.school.hhEmployersDto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HhEmployersDto {
    private Integer perPage;
    private Integer page;
    private Integer pages;
    private Integer found;
    private List<HhEmployerItem> items = null;

    public HhEmployersDto(@JsonProperty("per_page") Integer perPage,
                          @JsonProperty("page") Integer page,
                          @JsonProperty("pages") Integer pages,
                          @JsonProperty("found") Integer found,
                          @JsonProperty("items") List<HhEmployerItem> items) {
        this.perPage = perPage;
        this.page = page;
        this.pages = pages;
        this.found = found;
        this.items = items;
    }

    public List<HhEmployerItem> getItems() {
        return items;
    }
}
