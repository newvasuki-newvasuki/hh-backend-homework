package ru.hh.school.hhEmployersDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HhEmployerItem {
    private String id;
    private String name;
    private String url;
    private String alternateUrl;
    private String vacanciesUrl;
    private Integer openVacancies;
    private HhLogoUrls logoUrls;

    public HhEmployerItem(@JsonProperty("id") String id,
                          @JsonProperty("name") String name,
                          @JsonProperty("url") String url,
                          @JsonProperty("alternate_url") String alternateUrl,
                          @JsonProperty("vacancies_url") String vacanciesUrl,
                          @JsonProperty("open_vacancies") Integer openVacancies,
                          @JsonProperty("logo_urls") HhLogoUrls logoUrls) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.alternateUrl = alternateUrl;
        this.vacanciesUrl = vacanciesUrl;
        this.openVacancies = openVacancies;
        this.logoUrls = logoUrls;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
