package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.util.TimestampConverter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface FCMaterialsCapiMessage {

    String EVENT = "FCMaterials";

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
                @JsonProperty("CarrierID") String carrierID,
                @JsonProperty("Items") Items items,
                @JsonProperty("MarketID") long marketID,
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

    record Items(
            @JsonProperty("purchases") List<PurchaseItem> purchases,
            @JsonProperty("sales") Map<String, SaleItem> sales
    ) {}

    record PurchaseItem(
            @JsonProperty("name") String name,
            @JsonProperty("outstanding") int outstanding,
            @JsonProperty("price") long price,
            @JsonProperty("total") int total
    ) {}

    record SaleItem(
            @JsonProperty("id") long id,
            @JsonProperty("name") String name,
            @JsonProperty("price") long price,
            @JsonProperty("stock") int stock
    ) {}
}
