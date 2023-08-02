package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.util.TimestampConverter;

import java.time.LocalDateTime;

public interface NavRouteMessage {

    record V1(
            @JsonProperty("$schemaRef") String schemaRef,
            @JsonProperty("header") EddnMessage.Header header,
            @JsonProperty("message") V1.Payload message
    ) implements TimestampedEddnMessage<V1.Payload> {

        @Override
        public LocalDateTime messageTimeStamp() {
            return TimestampConverter.convertToLocalDateTime(message.timestamp);
        }

        record Payload(
                @JsonProperty("event") String event,
                @JsonProperty("horizons") boolean horizons,
                @JsonProperty("odyssey") boolean odyssey,
                @JsonProperty("Route") Item[] items,
                @JsonProperty("timestamp") String timestamp
        ) implements EddnMessage.Payload {}

        record Item(
                @JsonProperty("StarClass") String starClass,
                @JsonProperty("StarPos") Double[] starPos,
                @JsonProperty("StarSystem") String starSystem,
                @JsonProperty("SystemAddress") Long systemAddress
        ) {}
    }
}