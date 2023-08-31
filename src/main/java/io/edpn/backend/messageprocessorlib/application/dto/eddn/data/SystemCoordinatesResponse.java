package io.edpn.backend.messageprocessorlib.application.dto.eddn.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SystemCoordinatesResponse(
        @JsonProperty("systemName") String systemName,
        @JsonProperty("xCoordinate") double xCoordinate,
        @JsonProperty("yCoordinate") double yCoordinate,
        @JsonProperty("zCoordinate") double zCoordinate
) {}
