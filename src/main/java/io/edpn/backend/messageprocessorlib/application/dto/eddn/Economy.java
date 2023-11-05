package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Economy(
        @JsonProperty("name") String name,
        @JsonProperty("proportion") double proportion
) {}
