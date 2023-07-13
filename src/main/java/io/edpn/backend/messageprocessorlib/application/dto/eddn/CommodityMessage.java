package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.util.TimestampConverter;
import java.time.LocalDateTime;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public interface CommodityMessage {
    class V3 implements withMessageTimestamp {
        @JsonProperty("$schemaRef")
        private String schemaRef;
        @JsonProperty("header")
        private Common.EddnMessageHeader header;
        @JsonProperty("message")
        private Message message;

        public V3() {
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

            V3 v3 = (V3) o;

            return new EqualsBuilder().append(schemaRef, v3.schemaRef).append(header, v3.header).append(message, v3.message).isEquals();
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
            @JsonProperty("systemName")
            private String systemName;
            @JsonProperty("stationName")
            private String stationName;
            @JsonProperty("marketId")
            private long marketId;
            @JsonProperty("horizons")
            private boolean horizons;
            @JsonProperty("odyssey")
            private boolean odyssey;
            @JsonProperty("timestamp")
            private String timestamp;
            @JsonProperty("economies")
            private Economy[] economies;
            @JsonProperty("prohibited")
            private String[] prohibited;
            @JsonProperty("commodities")
            private Commodity[] commodities;

            public Message() {
            }

            public String getSystemName() {
                return this.systemName;
            }

            public String getStationName() {
                return this.stationName;
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

            public String getTimestamp() {
                return this.timestamp;
            }

            public Economy[] getEconomies() {
                return this.economies;
            }

            public String[] getProhibited() {
                return this.prohibited;
            }

            public Commodity[] getCommodities() {
                return this.commodities;
            }

            @JsonProperty("systemName")
            public void setSystemName(String systemName) {
                this.systemName = systemName;
            }

            @JsonProperty("stationName")
            public void setStationName(String stationName) {
                this.stationName = stationName;
            }

            @JsonProperty("marketId")
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

            @JsonProperty("timestamp")
            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }

            @JsonProperty("economies")
            public void setEconomies(Economy[] economies) {
                this.economies = economies;
            }

            @JsonProperty("prohibited")
            public void setProhibited(String[] prohibited) {
                this.prohibited = prohibited;
            }

            @JsonProperty("commodities")
            public void setCommodities(Commodity[] commodities) {
                this.commodities = commodities;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;

                if (o == null || getClass() != o.getClass()) return false;

                Message message = (Message) o;

                return new EqualsBuilder().append(marketId, message.marketId).append(horizons, message.horizons).append(odyssey, message.odyssey).append(systemName, message.systemName).append(stationName, message.stationName).append(timestamp, message.timestamp).append(economies, message.economies).append(prohibited, message.prohibited).append(commodities, message.commodities).isEquals();
            }

            @Override
            public int hashCode() {
                return new HashCodeBuilder(17, 37).append(systemName).append(stationName).append(marketId).append(horizons).append(odyssey).append(timestamp).append(economies).append(prohibited).append(commodities).toHashCode();
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this)
                        .append("systemName", systemName)
                        .append("stationName", stationName)
                        .append("marketId", marketId)
                        .append("horizons", horizons)
                        .append("odyssey", odyssey)
                        .append("timestamp", timestamp)
                        .append("economies", economies)
                        .append("prohibited", prohibited)
                        .append("commodities", commodities)
                        .toString();
            }
        }

        public static class Commodity {
            @JsonProperty("name")
            private String name;
            @JsonProperty("meanPrice")
            private int meanPrice;
            @JsonProperty("buyPrice")
            private int buyPrice;
            @JsonProperty("stock")
            private int stock;
            @JsonProperty("stockBracket")
            private int stockBracket;
            @JsonProperty("sellPrice")
            private int sellPrice;
            @JsonProperty("demand")
            private int demand;
            @JsonProperty("demandBracket")
            private int demandBracket;
            @JsonProperty("statusFlags")
            private String[] statusFlags;

            public Commodity() {
            }

            public String getName() {
                return this.name;
            }

            public int getMeanPrice() {
                return this.meanPrice;
            }

            public int getBuyPrice() {
                return this.buyPrice;
            }

            public int getStock() {
                return this.stock;
            }

            public int getStockBracket() {
                return this.stockBracket;
            }

            public int getSellPrice() {
                return this.sellPrice;
            }

            public int getDemand() {
                return this.demand;
            }

            public int getDemandBracket() {
                return this.demandBracket;
            }

            public String[] getStatusFlags() {
                return this.statusFlags;
            }

            @JsonProperty("name")
            public void setName(String name) {
                this.name = name;
            }

            @JsonProperty("meanPrice")
            public void setMeanPrice(int meanPrice) {
                this.meanPrice = meanPrice;
            }

            @JsonProperty("buyPrice")
            public void setBuyPrice(int buyPrice) {
                this.buyPrice = buyPrice;
            }

            @JsonProperty("stock")
            public void setStock(int stock) {
                this.stock = stock;
            }

            @JsonProperty("stockBracket")
            public void setStockBracket(int stockBracket) {
                this.stockBracket = stockBracket;
            }

            @JsonProperty("sellPrice")
            public void setSellPrice(int sellPrice) {
                this.sellPrice = sellPrice;
            }

            @JsonProperty("demand")
            public void setDemand(int demand) {
                this.demand = demand;
            }

            @JsonProperty("demandBracket")
            public void setDemandBracket(int demandBracket) {
                this.demandBracket = demandBracket;
            }

            @JsonProperty("statusFlags")
            public void setStatusFlags(String[] statusFlags) {
                this.statusFlags = statusFlags;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;

                if (o == null || getClass() != o.getClass()) return false;

                Commodity commodity = (Commodity) o;

                return new EqualsBuilder().append(meanPrice, commodity.meanPrice).append(buyPrice, commodity.buyPrice).append(stock, commodity.stock).append(stockBracket, commodity.stockBracket).append(sellPrice, commodity.sellPrice).append(demand, commodity.demand).append(demandBracket, commodity.demandBracket).append(name, commodity.name).append(statusFlags, commodity.statusFlags).isEquals();
            }

            @Override
            public int hashCode() {
                return new HashCodeBuilder(17, 37).append(name).append(meanPrice).append(buyPrice).append(stock).append(stockBracket).append(sellPrice).append(demand).append(demandBracket).append(statusFlags).toHashCode();
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this)
                        .append("name", name)
                        .append("meanPrice", meanPrice)
                        .append("buyPrice", buyPrice)
                        .append("stock", stock)
                        .append("stockBracket", stockBracket)
                        .append("sellPrice", sellPrice)
                        .append("demand", demand)
                        .append("demandBracket", demandBracket)
                        .append("statusFlags", statusFlags)
                        .toString();
            }
        }

        public static class Economy {
            @JsonProperty("name")
            private String name;
            @JsonProperty("proportion")
            private double proportion;

            public Economy() {
            }

            public String getName() {
                return this.name;
            }

            public double getProportion() {
                return this.proportion;
            }

            @JsonProperty("name")
            public void setName(String name) {
                this.name = name;
            }

            @JsonProperty("proportion")
            public void setProportion(double proportion) {
                this.proportion = proportion;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;

                if (o == null || getClass() != o.getClass()) return false;

                Economy economy = (Economy) o;

                return new EqualsBuilder().append(proportion, economy.proportion).append(name, economy.name).isEquals();
            }

            @Override
            public int hashCode() {
                return new HashCodeBuilder(17, 37).append(name).append(proportion).toHashCode();
            }

            @Override
            public String toString() {
                return new ToStringBuilder(this)
                        .append("name", name)
                        .append("proportion", proportion)
                        .toString();
            }
        }
    }
}
