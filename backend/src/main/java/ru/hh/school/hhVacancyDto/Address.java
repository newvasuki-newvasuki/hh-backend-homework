package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Address {

    public String city;
    public String street;
    public String building;
    public String description;
    public Float lat;
    public Float lng;
    public String raw;
    public MetroStation metro;
    public List<MetroStation> metroStations = null;
    public String id;

    public Address(@JsonProperty("city") String city,
                   @JsonProperty("street") String street,
                   @JsonProperty("building") String building,
                   @JsonProperty("description") String description,
                   @JsonProperty("lat") Float lat,
                   @JsonProperty("lng") Float lng,
                   @JsonProperty("raw") String raw,
                   @JsonProperty("metro") MetroStation metro,
                   @JsonProperty("metro_stations") List<MetroStation> metroStations,
                   @JsonProperty("id") String id) {
        this.city = city;
        this.street = street;
        this.building = building;
        this.description = description;
        this.lat = lat;
        this.lng = lng;
        this.raw = raw;
        this.metro = metro;
        this.metroStations = metroStations;
        this.id = id;
    }

}
