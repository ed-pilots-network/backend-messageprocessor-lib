package io.edpn.backend.messageprocessorlib.application.dto.edpn.intermodulecommunication;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface SystemCoordinatesResponse {
    @JsonProperty("systemName")
    String systemName();

    @JsonProperty("xCoordinate")
    double xCoordinate();

    @JsonProperty("yCoordinate")
    double yCoordinate();

    @JsonProperty("zCoordinate")
    double zCoordinate();
}
