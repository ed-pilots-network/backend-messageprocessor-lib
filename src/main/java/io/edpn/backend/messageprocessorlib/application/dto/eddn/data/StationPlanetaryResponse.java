package io.edpn.backend.messageprocessorlib.application.dto.eddn.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StationPlanetaryResponse(
        @JsonProperty("stationName") String stationName,
        @JsonProperty("systemName") String systemName,
        @JsonProperty("planetary") boolean planetary
) {}
