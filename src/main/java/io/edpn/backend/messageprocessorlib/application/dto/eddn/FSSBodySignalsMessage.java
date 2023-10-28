package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.util.TimestampConverter;

import java.time.LocalDateTime;
import java.util.List;

public interface FSSBodySignalsMessage {

    String EVENT = "FSSBodySignals";

    record V1(
            @JsonProperty("$schemaRef") String schemaRef,
            @JsonProperty("header") EddnMessage.Header header,
            @JsonProperty("message") V1.Payload message
    ) implements TimestampedEddnMessage<V1.Payload> {

        @Override
        public LocalDateTime messageTimeStamp() {
            return TimestampConverter.convertToLocalDateTime(message.timestamp());
        }

        public record Payload(
                @JsonProperty("BodyID") long bodyId,
                @JsonProperty("BodyName") String bodyName,
                @JsonProperty("Signals") List<Signal> signals,
                @JsonProperty("StarPos") double[] starPos,
                @JsonProperty("StarSystem") String starSystem,
                @JsonProperty("SystemAddress") long systemAddress,
                @JsonProperty("event") String event,
                @JsonProperty("horizons") boolean horizons,
                @JsonProperty("odyssey") boolean odyssey,
                @JsonProperty("timestamp") String timestamp
        ) implements EddnMessage.Payload {

            @JsonProperty(value = "event", access = JsonProperty.Access.READ_ONLY)
            public String event() {
                return EVENT;
            }

            public record Signal(
                    @JsonProperty("Count") int count,
                    @JsonProperty("Type") String type
            ) {
            }

        }
    }
}