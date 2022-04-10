package ru.hh.school.hhVacanciesDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.hh.school.hhVacancyDto.*;


import java.util.List;

public class HhVacancyItem {

    private String id;
    private String name;

    private Employer employer;
    private Area area;
    private Salary salary;
    private String createdAt;
    private InsiderInterview insiderInterview;

    private String url;
    private String publishedAt;
    private List<String> relations = null;

    private Contacts contacts;
    private Boolean responseLetterRequired;
    private Address address;
    private Float sortPointDistance;
    private String alternateUrl;
    private String applyAlternateUrl;
    private Department department;
    private Type type;

    private Boolean hasTest;
    private Object responseUrl;
    private Snippet snippet;
    private Schedule schedule;
    private Counters counters;
    private boolean premium;

    private boolean archived;
    private List<WorkingDay> workingDays = null;
    private List<WorkingTimeInterval> workingTimeIntervals = null;
    private List<WorkingTimeMode> workingTimeModes = null;
    private boolean acceptTemporary;

    public HhVacancyItem(                         @JsonProperty("id") String id,
                                                  @JsonProperty("name") String name,
                                                  @JsonProperty("area") Area area,
                                                  @JsonProperty("employer") Employer employer,
                                                  @JsonProperty("salary") Salary salary,
                                                  @JsonProperty("created_at") String createdAt,
                         @JsonProperty("insider_interview") InsiderInterview insiderInterview,

                         @JsonProperty("url") String url,
                         @JsonProperty("published_at") String publishedAt,
                         @JsonProperty("relations") List<String> relations,

                         @JsonProperty("contacts") Contacts contacts,
                         @JsonProperty("response_letter_required") Boolean responseLetterRequired,
                         @JsonProperty("address") Address address,
                         @JsonProperty("sort_point_distance") Float sortPointDistance,
                         @JsonProperty("alternate_url") String alternateUrl,
                         @JsonProperty("apply_alternate_url") String applyAlternateUrl,
                         @JsonProperty("department") Department department,
                         @JsonProperty("type") Type type,

                         @JsonProperty("has_test") Boolean hasTest,
                         @JsonProperty("response_url") Object responseUrl,
                         @JsonProperty("snippet") Snippet snippet,
                         @JsonProperty("schedule") Schedule schedule,
                         @JsonProperty("counters") Counters counters,
                         @JsonProperty("premium") boolean premium,

                         @JsonProperty("archived") boolean archived,
                         @JsonProperty("working_days") List<WorkingDay> workingDays,
                         @JsonProperty("working_time_intervals") List<WorkingTimeInterval> workingTimeIntervals,
                         @JsonProperty("working_time_modes") List<WorkingTimeMode> workingTimeModes,
                         @JsonProperty("accept_temporary") boolean acceptTemporary) {
        this.salary = salary;
        this.name = name;
        this.insiderInterview = insiderInterview;
        this.area = area;
        this.url = url;
        this.publishedAt = publishedAt;
        this.relations = relations;
        this.employer = employer;
        this.contacts = contacts;
        this.responseLetterRequired = responseLetterRequired;
        this.address = address;
        this.sortPointDistance = sortPointDistance;
        this.alternateUrl = alternateUrl;
        this.applyAlternateUrl = applyAlternateUrl;
        this.department = department;
        this.type = type;
        this.id = id;
        this.hasTest = hasTest;
        this.responseUrl = responseUrl;
        this.snippet = snippet;
        this.schedule = schedule;
        this.counters = counters;
        this.premium = premium;
        this.createdAt = createdAt;
        this.archived = archived;
        this.workingDays = workingDays;
        this.workingTimeIntervals = workingTimeIntervals;
        this.workingTimeModes = workingTimeModes;
        this.acceptTemporary = acceptTemporary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public Area getArea() {
        return area;
    }

    public Salary getSalary() {
        return salary;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
