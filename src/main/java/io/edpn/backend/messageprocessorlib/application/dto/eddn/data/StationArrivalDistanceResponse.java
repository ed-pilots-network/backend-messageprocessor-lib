package io.edpn.backend.messageprocessorlib.application.dto.eddn.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StationArrivalDistanceResponse(
        @JsonProperty("stationName") String stationName,
        @JsonProperty("systemName") String systemName,
        @JsonProperty("arrivalDistance") double arrivalDistance
) {}
