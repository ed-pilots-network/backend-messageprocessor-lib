package io.edpn.backend.messageprocessorlib.application.dto.eddn.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SystemDataRequest(
        @JsonProperty("requestingModule") String requestingModule,
        @JsonProperty("systemName")String systemName
) {}
