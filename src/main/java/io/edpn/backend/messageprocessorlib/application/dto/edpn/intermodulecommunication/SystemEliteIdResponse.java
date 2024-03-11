package io.edpn.backend.messageprocessorlib.application.dto.edpn.intermodulecommunication;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface SystemEliteIdResponse {
    @JsonProperty("systemName")
    String systemName();

    @JsonProperty("eliteId")
    long eliteId();
}
