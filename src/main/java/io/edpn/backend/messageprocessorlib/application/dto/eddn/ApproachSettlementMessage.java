package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.util.TimestampConverter;
import java.time.LocalDateTime;

public interface ApproachSettlementMessage {

    String EVENT = "ApproachSettlement";

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
                @JsonProperty("SystemAddress") long systemAddress,
                @JsonProperty("StarSystem")String starSystem,
                @JsonProperty("StarPos") double[] starPos,
                @JsonProperty("MarketID") long marketId,
                @JsonProperty("horizons") boolean horizons,
                @JsonProperty("odyssey") boolean odyssey,
                @JsonProperty("BodyID") long bodyId,
                @JsonProperty("BodyName") String bodyName,
                @JsonProperty("Name") String name,
                @JsonProperty("Latitude") long latitude,
                @JsonProperty("Longitude") long longitude,
                @JsonProperty("timestamp") String timestamp
        ) implements EddnMessage.Payload {

            @JsonProperty(value = "event", access = JsonProperty.Access.READ_ONLY)
            public String event() {
                return EVENT;
            }

        }
    }
}
