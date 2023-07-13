package io.edpn.backend.messageprocessorlib.application.dto.eddn.data;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class StationArrivalDistanceResponse {
    @JsonProperty("stationName")
    private String stationName;
    @JsonProperty("systemName")
    private String systemName;
    @JsonProperty("arrivalDistance")
    private double arrivalDistance;

    public StationArrivalDistanceResponse() {
    }

    public String getStationName() {
        return this.stationName;
    }

    public String getSystemName() {
        return this.systemName;
    }

    public double getArrivalDistance() {
        return this.arrivalDistance;
    }

    @JsonProperty("stationName")
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @JsonProperty("systemName")
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @JsonProperty("arrivalDistance")
    public void setArrivalDistance(double arrivalDistance) {
        this.arrivalDistance = arrivalDistance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        StationArrivalDistanceResponse that = (StationArrivalDistanceResponse) o;

        return new EqualsBuilder().append(arrivalDistance, that.arrivalDistance).append(stationName, that.stationName).append(systemName, that.systemName).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(stationName).append(systemName).append(arrivalDistance).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("stationName", stationName)
                .append("systemName", systemName)
                .append("arrivalDistance", arrivalDistance)
                .toString();
    }
}
