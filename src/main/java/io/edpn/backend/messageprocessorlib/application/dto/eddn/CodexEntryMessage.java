package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.util.TimestampConverter;

import java.time.LocalDateTime;

public interface CodexEntryMessage {

    String EVENT = "CodexEntry";

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
                @JsonProperty("Category") String category,
                @JsonProperty("EntryID") long entryId,
                @JsonProperty("Latitude") Double latitude,
                @JsonProperty("Longitude") Double longitude,
                @JsonProperty("Name") String name,
                @JsonProperty("NearestDestination") String nearestDestination,
                @JsonProperty("Region") String region,
                @JsonProperty("StarPos") double[] starPos,
                @JsonProperty("SubCategory") String subCategory,
                @JsonProperty("System") String system,
                @JsonProperty("SystemAddress") long systemAddress,
                @JsonProperty("VoucherAmount") Integer voucherAmount,
                @JsonProperty("Traits") String[] traits,
                @JsonProperty("event") String event,
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
