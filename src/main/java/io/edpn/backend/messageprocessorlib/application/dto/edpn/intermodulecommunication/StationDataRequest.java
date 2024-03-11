package io.edpn.backend.messageprocessorlib.application.dto.edpn.intermodulecommunication;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.util.Module;

public interface StationDataRequest {
    @JsonProperty("requestingModule")
    Module requestingModule();

    @JsonProperty("stationName")
    String stationName();

    @JsonProperty("systemName")
    String systemName();
}
