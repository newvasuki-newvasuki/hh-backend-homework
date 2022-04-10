package ru.hh.school.hhVacanciesDto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HhVacanciesDto {

    public Integer perPage;
    public List<HhVacancyItem> items = null;
    public Integer page;
    public Integer pages;
    public Integer found;
    public String clusters;
    public String arguments;
    public String alternateUrl;

    public HhVacanciesDto(@JsonProperty("per_page") Integer perPage,
                          @JsonProperty("items") List<HhVacancyItem> items,
                          @JsonProperty("page") Integer page,
                          @JsonProperty("pages") Integer pages,
                          @JsonProperty("found") Integer found,
                          @JsonProperty("clusters") String clusters,
                          @JsonProperty("arguments") String arguments,
                          @JsonProperty("alternate_url") String alternateUrl) {
        this.perPage = perPage;
        this.items = items;
        this.page = page;
        this.pages = pages;
        this.found = found;
        this.clusters = clusters;
        this.arguments = arguments;
        this.alternateUrl = alternateUrl;
    }

    public List<HhVacancyItem> getItems() {
        return items;
    }
}
