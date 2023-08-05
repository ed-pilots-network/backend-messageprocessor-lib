package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.util.TimestampConverter;

import java.time.LocalDateTime;
import java.util.List;

public interface FssSignalDiscoveredMessage {

    String EVENT = "FSSSignalDiscovered";

    record V1(
            @JsonProperty("$schemaRef")
            String schemaRef,
            @JsonProperty("header") EddnMessage.Header header,
            @JsonProperty("message") V1.Payload message
    ) implements TimestampedEddnMessage<V1.Payload> {

        @Override
        public LocalDateTime messageTimeStamp() {
            return TimestampConverter.convertToLocalDateTime(message.timestamp);
        }

        public record Payload(
                @JsonProperty("StarPos") Double[] starPos,
                @JsonProperty("StarSystem") String starSystem,
                @JsonProperty("SystemAddress") Long systemAddress,
                @JsonProperty("event") String event,
                @JsonProperty("horizons") boolean horizons,
                @JsonProperty("odyssey") boolean odyssey,
                @JsonProperty("signals") List<Signal> signals,
                @JsonProperty("timestamp") String timestamp
        ) implements EddnMessage.Payload {

            @JsonProperty(value = "event", access = JsonProperty.Access.READ_ONLY)
            public String event() {
                return EVENT;
            }

        }

        public record Signal(
                @JsonProperty("IsStation") String isStation,
                @JsonProperty("SignalName") String signalName,
                @JsonProperty("SpawningFaction") String spawningFaction,
                @JsonProperty("SpawningState") String spawningState,
                @JsonProperty("ThreatLevel") int threatLevel,
                @JsonProperty("USSType") String ussType,
                @JsonProperty("timestamp") String timestamp
        ) {}
    }
}
