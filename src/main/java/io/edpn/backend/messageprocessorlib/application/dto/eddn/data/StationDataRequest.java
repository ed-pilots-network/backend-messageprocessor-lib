package io.edpn.backend.messageprocessorlib.application.dto.eddn.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StationDataRequest(
        @JsonProperty("requestingModule") String requestingModule,
        @JsonProperty("stationName") String stationName,
        @JsonProperty("systemName") String systemName
) {}
