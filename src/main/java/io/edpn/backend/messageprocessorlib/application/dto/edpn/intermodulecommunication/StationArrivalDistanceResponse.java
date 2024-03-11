package io.edpn.backend.messageprocessorlib.application.dto.edpn.intermodulecommunication;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface StationArrivalDistanceResponse {
    @JsonProperty("stationName")
    String stationName();

    @JsonProperty("systemName")
    String systemName();

    @JsonProperty("arrivalDistance")
    double arrivalDistance();
}
