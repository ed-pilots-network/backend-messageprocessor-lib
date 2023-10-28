package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.util.TimestampConverter;

import java.time.LocalDateTime;

public interface FCMaterialsJournalMessage {

    String EVENT = "FCMaterials";

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
                @JsonProperty("CarrierID") String carrierID,
                @JsonProperty("CarrierName") String carrierName,
                @JsonProperty("Items") Item[] items,
                @JsonProperty("MarketID") long marketId,
                @JsonProperty("horizons") boolean horizons,
                @JsonProperty("odyssey") boolean odyssey,
                @JsonProperty("timestamp") String timestamp
        ) implements EddnMessage.Payload {

            @JsonProperty(value = "event", access = JsonProperty.Access.READ_ONLY)
            public String event() {
                return EVENT;
            }

            public record Item(
                    @JsonProperty("Demand") int demand,
                    @JsonProperty("Name") String name,
                    @JsonProperty("Price") int price,
                    @JsonProperty("Stock") int stock,
                    @JsonProperty("id") int id
            ) {
            }

        }
    }
}
