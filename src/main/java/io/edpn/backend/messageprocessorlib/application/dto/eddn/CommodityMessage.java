package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.util.TimestampConverter;
import java.time.LocalDateTime;

public interface CommodityMessage {

    record V3(
            @JsonProperty("$schemaRef") String schemaRef,
            @JsonProperty("header") EddnMessage.Header header,
            @JsonProperty("message") V3.Payload message
    ) implements TimestampedEddnMessage<V3.Payload> {

        @Override
        public LocalDateTime messageTimeStamp() {
            return TimestampConverter.convertToLocalDateTime(message.timestamp());
        }

        public record Payload(
                @JsonProperty("systemName") String systemName,
                @JsonProperty("stationName") String stationName,
                @JsonProperty("marketId") long marketId,
                @JsonProperty("horizons") boolean horizons,
                @JsonProperty("odyssey") boolean odyssey,
                @JsonProperty("timestamp") String timestamp,
                @JsonProperty("economies") Economy[] economies,
                @JsonProperty("prohibited") String[] prohibited,
                @JsonProperty("commodities") Commodity[] commodities
        ) implements EddnMessage.Payload {}

        public record Commodity(
                @JsonProperty("name") String name,
                @JsonProperty("meanPrice") int meanPrice,
                @JsonProperty("buyPrice") int buyPrice,
                @JsonProperty("stock") int stock,
                @JsonProperty("stockBracket") int stockBracket,
                @JsonProperty("sellPrice") int sellPrice,
                @JsonProperty("demand") int demand,
                @JsonProperty("demandBracket") int demandBracket,
                @JsonProperty("statusFlags") String[] statusFlags
        ) {}

    }

}
