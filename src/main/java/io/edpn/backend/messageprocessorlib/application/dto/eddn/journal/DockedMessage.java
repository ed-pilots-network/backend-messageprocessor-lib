package io.edpn.backend.messageprocessorlib.application.dto.eddn.journal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.messageprocessorlib.application.dto.eddn.EddnMessage;
import io.edpn.backend.messageprocessorlib.application.dto.eddn.TimestampedEddnMessage;
import io.edpn.backend.util.TimestampConverter;

import java.time.LocalDateTime;
import java.util.List;

public interface DockedMessage {

    String EVENT = "JournalDocked";

    record V1(
            @JsonProperty("$schemaRef") String schemaRef,
            @JsonProperty("header") EddnMessage.Header header,
            @JsonProperty("message") Payload message) implements TimestampedEddnMessage<EddnMessage.Payload> {

        @Override
        public LocalDateTime messageTimeStamp() {
            return TimestampConverter.convertToLocalDateTime(message.timestamp);
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Payload(
                @JsonProperty("DistFromStarLS") Double distanceFromStar,
                @JsonProperty("LandingPads") LandingPads landingPads,
                @JsonProperty("MarketID") Long marketId,
                @JsonProperty("StarPos") Double[] starPosition,
                @JsonProperty("StarSystem") String starSystem,
                @JsonProperty("StationEconomies") List<Economy> stationEconomies,
                @JsonProperty("StationEconomy") String stationEconomy,
                @JsonProperty("StationFaction") Faction stationFaction,
                @JsonProperty("StationGovernment") String stationGovernment,
                @JsonProperty("StationName") String stationName,
                @JsonProperty("StationServices") List<String> stationServices,
                @JsonProperty("StationType") String stationType,
                @JsonProperty("SystemAddress") Long systemAddress,
                @JsonProperty("Taxi") Boolean taxi,
                @JsonProperty("event") String event,
                @JsonProperty("horizons") Boolean horizons,
                @JsonProperty("odyssey") Boolean odyssey,
                @JsonProperty("timestamp") String timestamp
        ) implements EddnMessage.Payload {

            @JsonProperty(value = "event", access = JsonProperty.Access.READ_ONLY)
            public String event() {
                return EVENT;
            }

            public record LandingPads(
                    @JsonProperty("Large") Integer large,
                    @JsonProperty("Medium") Integer medium,
                    @JsonProperty("Small") Integer small
            ) {
            }

            public record Economy(
                    @JsonProperty("Name") String name,
                    @JsonProperty("Proportion") Double proportion
            ) {
            }

            public record Faction(
                    @JsonProperty("Name") String name,
                    @JsonProperty("FactionState") String factionState
            ) {
            }
        }
    }
}
