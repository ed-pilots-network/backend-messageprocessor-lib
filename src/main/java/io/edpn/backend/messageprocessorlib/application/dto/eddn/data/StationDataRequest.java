package io.edpn.backend.messageprocessorlib.application.dto.eddn.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class StationDataRequest {

    @JsonProperty("stationName")
    private String stationName;
    @JsonProperty("systemName")
    private String systemName;

    public StationDataRequest() {
    }

    public String getStationName() {
        return this.stationName;
    }

    public String getSystemName() {
        return this.systemName;
    }

    @JsonProperty("stationName")
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @JsonProperty("systemName")
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        StationDataRequest that = (StationDataRequest) o;

        return new EqualsBuilder().append(stationName, that.stationName).append(systemName, that.systemName).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(stationName).append(systemName).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("stationName", stationName)
                .append("systemName", systemName)
                .toString();
    }
}
