package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.util.TimestampConverter;
import java.time.LocalDateTime;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public interface ApproachSettlementMessage {

    class V1 implements withMessageTimestamp {
        @JsonProperty("$schemaRef")
        private String schemaRef;
        @JsonProperty("header")
        private Common.EddnMessageHeader header;
        @JsonProperty("message")
        private Message message;

        public V1() {
        }

        @Override
        public LocalDateTime getMessageTimeStamp() {
            return TimestampConverter.convertToLocalDateTime(message.getTimestamp());
        }

        public String getSchemaRef() {
            return this.schemaRef;
        }

        public Common.EddnMessageHeader getHeader() {
            return this.header;
        }

        public Message getMessage() {
            return this.message;
        }

        @JsonProperty("$schemaRef")
        public void setSchemaRef(String schemaRef) {
            this.schemaRef = schemaRef;
        }

        @JsonProperty("header")
        public void setHeader(Common.EddnMessageHeader header) {
            this.header = header;
        }

        @JsonProperty("message")
        public void setMessage(Message message) {
            this.message = message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            V1 v1 = (V1) o;

            return new EqualsBuilder().append(schemaRef, v1.schemaRef).append(header, v1.header).append(message, v1.message).isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37).append(schemaRef).append(header).append(message).toHashCode();
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("schemaRef", schemaRef)
                    .append("header", header)
                    .append("message", message)
                    .toString();
        }

        public static class Message {
            @JsonProperty("SystemAddress")
            private long systemAddress;
            @JsonProperty("StarSystem")
            private String starSystem;
            @JsonProperty("StarPos")
            private double[] starPos;
            @JsonProperty("MarketID")
            private long marketId;
            @JsonProperty("horizons")
            private boolean horizons;
            @JsonProperty("odyssey")
            private boolean odyssey;
            @JsonProperty("event")
            private Event event;
            @JsonProperty("BodyID")
            private long bodyId;
            @JsonProperty("BodyName")
            private String bodyName;
            @JsonProperty("Name")
            private String name;
            @JsonProperty("Latitude")
            private long latitude;
            @JsonProperty("Longitude")
            private long longitude;
            @JsonProperty("timestamp")
            private String timestamp;

            public Message() {
            }

            public long getSystemAddress() {
                return this.systemAddress;
            }

            public String getStarSystem() {
                return this.starSystem;
            }

            public double[] getStarPos() {
                return this.starPos;
            }

            public long getMarketId() {
                return this.marketId;
            }

            public boolean isHorizons() {
                return this.horizons;
            }

            public boolean isOdyssey() {
                return this.odyssey;
            }

            public Event getEvent() {
                return this.event;
            }

            public long getBodyId() {
                return this.bodyId;
            }

            public String getBodyName() {
                return this.bodyName;
            }

            public String getName() {
                return this.name;
            }

            public long getLatitude() {
                return this.latitude;
            }

            public long getLongitude() {
                return this.longitude;
            }

            public String getTimestamp() {
                return this.timestamp;
            }

            @JsonProperty("SystemAddress")
            public void setSystemAddress(long systemAddress) {
                this.systemAddress = systemAddress;
            }

            @JsonProperty("StarSystem")
            public void setStarSystem(String starSystem) {
                this.starSystem = starSystem;
            }

            @JsonProperty("StarPos")
            public void setStarPos(double[] starPos) {
                this.starPos = starPos;
            }

            @JsonProperty("MarketID")
            public void setMarketId(long marketId) {
                this.marketId = marketId;
            }

            @JsonProperty("horizons")
            public void setHorizons(boolean horizons) {
                this.horizons = horizons;
            }

            @JsonProperty("odyssey")
            public void setOdyssey(boolean odyssey) {
                this.odyssey = odyssey;
            }

            @JsonProperty("event")
            public void setEvent(Event event) {
                this.event = event;
            }

            @JsonProperty("BodyID")
            public void setBodyId(long bodyId) {
                this.bodyId = bodyId;
            }

            @JsonProperty("BodyName")
            public void setBodyName(String bodyName) {
                this.bodyName = bodyName;
            }

            @JsonProperty("Name")
            public void setName(String name) {
                this.name = name;
            }

            @JsonProperty("Latitude")
            public void setLatitude(long latitude) {
                this.latitude = latitude;
            }

            @JsonProperty("Longitude")
            public void setLongitude(long longitude) {
                this.longitude = longitude;
            }

            @JsonProperty("timestamp")
            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;

                if (o == null || getClass() != o.getClass()) return false;

                Message message = (Message) o;

                return new EqualsBuilder().append(systemAddress, message.systemAddress).append(marketId, message.marketId).append(horizons, message.horizons).append(odyssey, message.odyssey).append(bodyId, message.bodyId).append(latitude, message.latitude).append(longitude, message.longitude).append(starSystem, message.starSystem).append(starPos, message.starPos).append(event, message.event).append(bodyName, message.bodyName).append(name, message.name).append(timestamp, message.timestamp).isEquals();
            }

            @Override
            public int hashCode() {
                return new HashCodeBuilder(17, 37).append(systemAddress).append(starSystem).append(starPos).append(marketId).append(horizons).append(odyssey).append(event).append(bodyId).append(bodyName).append(name).append(latitude).append(longitude).append(timestamp).toHashCode();
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this)
                        .append("systemAddress", systemAddress)
                        .append("starSystem", starSystem)
                        .append("starPos", starPos)
                        .append("marketId", marketId)
                        .append("horizons", horizons)
                        .append("odyssey", odyssey)
                        .append("event", event)
                        .append("bodyId", bodyId)
                        .append("bodyName", bodyName)
                        .append("name", name)
                        .append("latitude", latitude)
                        .append("longitude", longitude)
                        .append("timestamp", timestamp)
                        .toString();
            }
        }

        public enum Event {
            ApproachSettlement
        }
    }
}
