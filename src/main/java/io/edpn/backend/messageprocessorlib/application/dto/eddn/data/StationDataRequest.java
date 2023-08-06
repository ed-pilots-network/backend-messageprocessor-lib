package io.edpn.backend.messageprocessorlib.application.dto.eddn.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.util.Module;

public record StationDataRequest(
        @JsonProperty("requestingModule") Module requestingModule,
        @JsonProperty("stationName") String stationName,
        @JsonProperty("systemName") String systemName
) {}
