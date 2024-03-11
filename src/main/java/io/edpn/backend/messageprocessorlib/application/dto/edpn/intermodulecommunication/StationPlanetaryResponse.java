package io.edpn.backend.messageprocessorlib.application.dto.edpn.intermodulecommunication;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface StationPlanetaryResponse {
    @JsonProperty("stationName")
    String stationName();

    @JsonProperty("systemName")
    String systemName();

    @JsonProperty("planetary")
    boolean planetary();
}
