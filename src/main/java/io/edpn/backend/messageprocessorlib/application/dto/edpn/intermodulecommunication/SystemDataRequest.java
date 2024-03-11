package io.edpn.backend.messageprocessorlib.application.dto.edpn.intermodulecommunication;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.util.Module;

public interface SystemDataRequest {
    @JsonProperty("requestingModule")
    Module requestingModule();

    @JsonProperty("systemName")
    String systemName();
}
