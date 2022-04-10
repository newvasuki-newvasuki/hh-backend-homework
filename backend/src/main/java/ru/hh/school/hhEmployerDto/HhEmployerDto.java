package ru.hh.school.hhEmployerDto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HhEmployerDto {
    private String    id;
    private String    name;
    private String    type;
    private String    siteUrl;
    private String    description;
    private String    brandedDescription;
    private String    vacanciesUrl;
    private Integer   openVacancies;
    private Boolean   trusted;
    private String    alternateUrl;
    private String    branding;
    private String    requestId;
    private List<HhInsiderInterviewDto> insiderInterviews = null;
    private HhLogoUrlsDto logoUrls;
    private HhAreaDto area;
    private List<String> relations = null;
    private List<HhIndustryDto> industries = null;
    private List<HhError>       errors = null;

    public HhEmployerDto(@JsonProperty("id")                   String     id,
                         @JsonProperty("name")                 String     name,
                         @JsonProperty("description")          String     description,
                         @JsonProperty("type")                 String     type,
                         @JsonProperty("site_url")             String     siteUrl,
                         @JsonProperty("branded_description")  String     brandedDescription,
                         @JsonProperty("vacancies_url")        String     vacanciesUrl,
                         @JsonProperty("open_vacancies")       Integer     openVacancies,
                         @JsonProperty("trusted")              Boolean     trusted,
                         @JsonProperty("alternate_url")        String     alternateUrl,
                         @JsonProperty("branding")             String     branding,
                         @JsonProperty("request_id")           String     requestId,
                         @JsonProperty("insider_interviews")   List<HhInsiderInterviewDto> insiderInterviews,
                         @JsonProperty("logo_urls")            HhLogoUrlsDto   logoUrls,
                         @JsonProperty("area")                 HhAreaDto  area,
                         @JsonProperty("relations")            List<String> relations,
                         @JsonProperty("industries")           List<HhIndustryDto> industries,
                         @JsonProperty("errors")                List<HhError>        errors){

        this.id          = id;
        this.name        = name;
        this.type        = type;
        this.siteUrl     = siteUrl;
        this.description = description;
        this.brandedDescription = brandedDescription;
        this.vacanciesUrl = vacanciesUrl;
        this.openVacancies = openVacancies;
        this.trusted = trusted;
        this.alternateUrl = alternateUrl;
        this.branding     = branding;
        this.requestId    = requestId;
        this.insiderInterviews = insiderInterviews;
        this.logoUrls = logoUrls;
        this.area        = area;
        this.relations = relations;
        this.industries = industries;
        this.errors     = errors;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public HhAreaDto getArea() {
        return area;
    }
}
