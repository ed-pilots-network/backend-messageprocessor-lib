package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Faction(
        @JsonProperty("Name") String name
) {}
