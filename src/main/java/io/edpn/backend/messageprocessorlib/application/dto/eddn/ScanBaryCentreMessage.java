package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.util.TimestampConverter;

import java.time.LocalDateTime;

public interface ScanBaryCentreMessage {

    String EVENT = "ScanBaryCentre";

    record V1(
            @JsonProperty("$schemaRef") String schemaRef,
            @JsonProperty("header") EddnMessage.Header header,
            @JsonProperty("message") V1.Payload message
    ) implements TimestampedEddnMessage<V1.Payload> {

        @Override
        public LocalDateTime messageTimeStamp() {
            return TimestampConverter.convertToLocalDateTime(message.timestamp);
        }

        public record Payload(
                @JsonProperty("AscendingNode") double ascendingNode,
                @JsonProperty("BodyID") long bodyID,
                @JsonProperty("Eccentricity") double eccentricity,
                @JsonProperty("MeanAnomaly") double meanAnomaly,
                @JsonProperty("OrbitalInclination") double orbitalInclination,
                @JsonProperty("OrbitalPeriod") double orbitalPeriod,
                @JsonProperty("Periapsis") double periapsis,
                @JsonProperty("SemiMajorAxis") double semiMajorAxis,
                @JsonProperty("StarPos") double[] starPos,
                @JsonProperty("StarSystem") String starSystem,
                @JsonProperty("SystemAddress") long systemAddress,
                @JsonProperty("horizons") boolean horizons,
                @JsonProperty("odyssey") boolean odyssey,
                @JsonProperty("timestamp") String timestamp
        ) implements EddnMessage.Payload {

            @JsonProperty(value = "event", access = JsonProperty.Access.READ_ONLY)
            public String event() {
                return EVENT;
            }

        }
    }
}