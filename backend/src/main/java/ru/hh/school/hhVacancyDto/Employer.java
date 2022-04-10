package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employer {

    private LogoUrls logoUrls;
    private String name;
    private String url;
    private String alternateUrl;
    private String id;
    private Boolean trusted;
    private Boolean blacklisted;
    private String vacanciesUrl;

    public Employer(@JsonProperty("logo_urls") LogoUrls logoUrls,
                    @JsonProperty("name") String name,
                    @JsonProperty("url") String url,
                    @JsonProperty("alternate_url") String alternateUrl,
                    @JsonProperty("id") String id,
                    @JsonProperty("trusted") Boolean trusted,
                    @JsonProperty("vacancies_url") String vacanciesUrl,
                    @JsonProperty("blacklisted") Boolean blacklisted) {
        this.logoUrls = logoUrls;
        this.name = name;
        this.url = url;
        this.alternateUrl = alternateUrl;
        this.id = id;
        this.trusted = trusted;
        this.vacanciesUrl = vacanciesUrl;
        this.blacklisted = blacklisted;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
