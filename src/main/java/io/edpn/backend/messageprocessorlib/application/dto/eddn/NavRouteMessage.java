package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.util.TimestampConverter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;

public interface NavRouteMessage {

    class V1 implements withMessageTimestamp {
        @JsonProperty("$schemaRef")
        private String schemaRef;
        @JsonProperty("header")
        private Common.EddnMessageHeader header;
        @JsonProperty("message")
        private Message message;

        public V1() {
        }

        public String getSchemaRef() {
            return schemaRef;
        }

        public void setSchemaRef(String schemaRef) {
            this.schemaRef = schemaRef;
        }

        public Common.EddnMessageHeader getHeader() {
            return header;
        }

        public void setHeader(Common.EddnMessageHeader header) {
            this.header = header;
        }

        public Message getMessage() {
            return message;
        }

        public void setMessage(Message message) {
            this.message = message;
        }

        @Override
        public LocalDateTime getMessageTimeStamp() {
            return TimestampConverter.convertToLocalDateTime(message.getTimestamp());
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
            @JsonProperty("event")
            private String event;
            @JsonProperty("horizons")
            private boolean horizons;
            @JsonProperty("odyssey")
            private boolean odyssey;
            @JsonProperty("Route")
            private Item[] items;
            @JsonProperty("timestamp")
            private String timestamp;

            public Message() {
            }

            public String getEvent() {
                return event;
            }

            public void setEvent(String event) {
                this.event = event;
            }

            public boolean isHorizons() {
                return horizons;
            }

            public void setHorizons(boolean horizons) {
                this.horizons = horizons;
            }

            public boolean isOdyssey() {
                return odyssey;
            }

            public void setOdyssey(boolean odyssey) {
                this.odyssey = odyssey;
            }

            public Item[] getItems() {
                return items;
            }

            public void setItems(Item[] items) {
                this.items = items;
            }

            public String getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;

                if (o == null || getClass() != o.getClass()) return false;

                Message message = (Message) o;

                return new EqualsBuilder().append(horizons, message.horizons).append(odyssey, message.odyssey).append(event, message.event).append(items, message.items).append(timestamp, message.timestamp).isEquals();
            }

            @Override
            public int hashCode() {
                return new HashCodeBuilder(17, 37).append(event).append(horizons).append(odyssey).append(items).append(timestamp).toHashCode();
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this)
                        .append("event", event)
                        .append("horizons", horizons)
                        .append("odyssey", odyssey)
                        .append("items", items)
                        .append("timestamp", timestamp)
                        .toString();
            }
        }

        public static class Item {
            @JsonProperty("StarClass")
            private String starClass;
            @JsonProperty("StarPos")
            private Double[] starPos;
            @JsonProperty("StarSystem")
            private String starSystem;
            @JsonProperty("SystemAddress")
            private Long systemAddress;

            public Item() {
            }

            public String getStarClass() {
                return starClass;
            }

            public void setStarClass(String starClass) {
                this.starClass = starClass;
            }

            public Double[] getStarPos() {
                return starPos;
            }

            public void setStarPos(Double[] starPos) {
                this.starPos = starPos;
            }

            public String getStarSystem() {
                return starSystem;
            }

            public void setStarSystem(String starSystem) {
                this.starSystem = starSystem;
            }

            public Long getSystemAddress() {
                return systemAddress;
            }

            public void setSystemAddress(Long systemAddress) {
                this.systemAddress = systemAddress;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;

                if (o == null || getClass() != o.getClass()) return false;

                Item item = (Item) o;

                return new EqualsBuilder().append(starClass, item.starClass).append(starPos, item.starPos).append(starSystem, item.starSystem).append(systemAddress, item.systemAddress).isEquals();
            }

            @Override
            public int hashCode() {
                return new HashCodeBuilder(17, 37).append(starClass).append(starPos).append(starSystem).append(systemAddress).toHashCode();
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this)
                        .append("starClass", starClass)
                        .append("starPos", starPos)
                        .append("starSystem", starSystem)
                        .append("systemAddress", systemAddress)
                        .toString();
            }
        }
    }
}