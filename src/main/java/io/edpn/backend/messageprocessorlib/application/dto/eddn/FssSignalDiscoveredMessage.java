package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.util.TimestampConverter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;
import java.util.List;

public interface FssSignalDiscoveredMessage {

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
            @JsonProperty("StarPos")
            private Double[] starPos;
            @JsonProperty("StarSystem")
            private String starSystem;
            @JsonProperty("SystemAddress")
            private Long systemAddress;
            @JsonProperty("event")
            private String event;
            @JsonProperty("horizons")
            private boolean horizons;
            @JsonProperty("odyssey")
            private boolean odyssey;
            @JsonProperty("signals")
            private List<Signal> signals;
            @JsonProperty("timestamp")
            private String timestamp;

            public Message() {
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

            public List<Signal> getSignals() {
                return signals;
            }

            public void setSignals(List<Signal> signals) {
                this.signals = signals;
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

                return new EqualsBuilder().append(horizons, message.horizons).append(odyssey, message.odyssey).append(starPos, message.starPos).append(starSystem, message.starSystem).append(systemAddress, message.systemAddress).append(event, message.event).append(signals, message.signals).append(timestamp, message.timestamp).isEquals();
            }

            @Override
            public int hashCode() {
                return new HashCodeBuilder(17, 37).append(starPos).append(starSystem).append(systemAddress).append(event).append(horizons).append(odyssey).append(signals).append(timestamp).toHashCode();
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this)
                        .append("starPos", starPos)
                        .append("starSystem", starSystem)
                        .append("systemAddress", systemAddress)
                        .append("event", event)
                        .append("horizons", horizons)
                        .append("odyssey", odyssey)
                        .append("signals", signals)
                        .append("timestamp", timestamp)
                        .toString();
            }
        }

        public static class Signal {
            @JsonProperty("IsStation")
            private String isStation;
            @JsonProperty("SignalName")
            private String signalName;
            @JsonProperty("SpawningFaction")
            private String spawningFaction;
            @JsonProperty("SpawningState")
            private String spawningState;
            @JsonProperty("ThreatLevel")
            private int threatLevel;
            @JsonProperty("USSType")
            private String ussType;
            @JsonProperty("timestamp")
            private String timestamp;

            public Signal() {
            }

            public String getIsStation() {
                return isStation;
            }

            public void setIsStation(String isStation) {
                this.isStation = isStation;
            }

            public String getSignalName() {
                return signalName;
            }

            public void setSignalName(String signalName) {
                this.signalName = signalName;
            }

            public String getSpawningFaction() {
                return spawningFaction;
            }

            public void setSpawningFaction(String spawningFaction) {
                this.spawningFaction = spawningFaction;
            }

            public String getSpawningState() {
                return spawningState;
            }

            public void setSpawningState(String spawningState) {
                this.spawningState = spawningState;
            }

            public int getThreatLevel() {
                return threatLevel;
            }

            public void setThreatLevel(int threatLevel) {
                this.threatLevel = threatLevel;
            }

            public String getUssType() {
                return ussType;
            }

            public void setUssType(String ussType) {
                this.ussType = ussType;
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

                Signal signal = (Signal) o;

                return new EqualsBuilder().append(threatLevel, signal.threatLevel).append(isStation, signal.isStation).append(signalName, signal.signalName).append(spawningFaction, signal.spawningFaction).append(spawningState, signal.spawningState).append(ussType, signal.ussType).append(timestamp, signal.timestamp).isEquals();
            }

            @Override
            public int hashCode() {
                return new HashCodeBuilder(17, 37).append(isStation).append(signalName).append(spawningFaction).append(spawningState).append(threatLevel).append(ussType).append(timestamp).toHashCode();
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this)
                        .append("isStation", isStation)
                        .append("signalName", signalName)
                        .append("spawningFaction", spawningFaction)
                        .append("spawningState", spawningState)
                        .append("threatLevel", threatLevel)
                        .append("ussType", ussType)
                        .append("timestamp", timestamp)
                        .toString();
            }
        }
    }
}
