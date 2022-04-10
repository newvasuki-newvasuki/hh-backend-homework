package ru.hh.school.entity;

import ru.hh.nab.common.properties.FileSettings;
import ru.hh.school.App;
import ru.hh.school.config.CommonConfig;
import ru.hh.school.hhVacancyDto.Salary;
import ru.hh.nab.common.properties.FileSettings;

import javax.persistence.*;
import javax.swing.*;
import java.time.LocalDateTime;

@Entity
public class Vacancy {

    @Id
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String employer;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @Column(name = "date_create")
    private LocalDateTime dateCreate;

    @Column
    private String comment;

    @Column
    private boolean gross;

    @Column(name = "to_to")
    private Integer to;

    @Column(name = "from_from")
    private Integer from;

    @Column
    private String currency;

    @Column(name = "created_at")
    private String createdAt;


    @Column(name = "views_count")
    private Integer viewsCount;

    public String getPopularity(){
        return viewsCount> App.limitPopularity?"POPULAR":"REGULAR";
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getViewsCount() {
        return viewsCount;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public Salary getSalary(){
        return new Salary(to,from,currency,gross);
    }

    public void setGross(boolean gross) {
        this.gross = gross;
    }

    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDateCreate() {
        return dateCreate.toString();
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Vacancy() {
        area = new Area();
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getEmployer() {
        return employer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
