package io.edpn.backend.messageprocessorlib.application.dto.eddn.data;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class StationMaxLandingPadSizeResponse {
    private String stationName;
    private String systemName;
    private String maxLandingPadSize;


    public StationMaxLandingPadSizeResponse() {
    }

    public String getStationName() {
        return this.stationName;
    }

    public String getSystemName() {
        return this.systemName;
    }

    public String getMaxLandingPadSize() {
        return this.maxLandingPadSize;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public void setMaxLandingPadSize(String maxLandingPadSize) {
        this.maxLandingPadSize = maxLandingPadSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        StationMaxLandingPadSizeResponse that = (StationMaxLandingPadSizeResponse) o;

        return new EqualsBuilder().append(stationName, that.stationName).append(systemName, that.systemName).append(maxLandingPadSize, that.maxLandingPadSize).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(stationName).append(systemName).append(maxLandingPadSize).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("stationName", stationName)
                .append("systemName", systemName)
                .append("maxLandingPadSize", maxLandingPadSize)
                .toString();
    }
}
