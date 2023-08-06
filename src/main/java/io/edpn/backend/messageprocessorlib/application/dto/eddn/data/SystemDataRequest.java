package io.edpn.backend.messageprocessorlib.application.dto.eddn.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.util.Module;

public record SystemDataRequest(
        @JsonProperty("requestingModule") Module requestingModule,
        @JsonProperty("systemName")String systemName
) {}
