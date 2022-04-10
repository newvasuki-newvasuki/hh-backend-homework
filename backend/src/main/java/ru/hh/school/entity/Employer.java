package ru.hh.school.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Employer {

    @Id
    @Column
    private Long id;

    @Column
    private String comment;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "date_create")
    private LocalDateTime dateCreate;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "area_id")
    private Area area;

    @Column(name="views_count")
    private Integer viewsCount;

    public String getPopularity(){
        return viewsCount>50?"POPULAR":"REGULAR";

    }

    public Employer() {
        area = new Area();
    }

    public Integer getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getDateCreate() {
        return dateCreate.toString();
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
