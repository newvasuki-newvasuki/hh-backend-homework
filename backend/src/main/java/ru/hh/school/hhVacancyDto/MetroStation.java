package ru.hh.school.hhVacancyDto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MetroStation {

    public String stationId;
    public String stationName;
    public String lineId;
    public String lineName;
    public Float lat;
    public Float lng;

    public MetroStation(@JsonProperty("station_id") String stationId,
                        @JsonProperty("station_name") String stationName,
                        @JsonProperty("line_id") String lineId,
                        @JsonProperty("line_name") String lineName,
                        @JsonProperty("lat") Float lat,
                        @JsonProperty("lng") Float lng) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.lineId = lineId;
        this.lineName = lineName;
        this.lat = lat;
        this.lng = lng;
    }

}
