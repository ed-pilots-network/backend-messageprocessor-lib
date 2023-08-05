package io.edpn.backend.messageprocessorlib.application.dto.eddn.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public record SystemEliteIdResponse(
        @JsonProperty("systemName") String systemName,
        @JsonProperty("eliteId") long eliteId
) {}
