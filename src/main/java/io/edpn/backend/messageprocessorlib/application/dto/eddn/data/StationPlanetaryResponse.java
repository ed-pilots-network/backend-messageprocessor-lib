package io.edpn.backend.messageprocessorlib.application.dto.eddn.data;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class StationPlanetaryResponse {
    @JsonProperty("stationName")
    private String stationName;
    @JsonProperty("systemName")
    private String systemName;
    @JsonProperty("planetary")
    private boolean planetary;

    public StationPlanetaryResponse() {
    }

    public String getStationName() {
        return this.stationName;
    }

    public String getSystemName() {
        return this.systemName;
    }

    public boolean isPlanetary() {
        return this.planetary;
    }

    @JsonProperty("stationName")
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @JsonProperty("systemName")
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @JsonProperty("planetary")
    public void setPlanetary(boolean planetary) {
        this.planetary = planetary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        StationPlanetaryResponse that = (StationPlanetaryResponse) o;

        return new EqualsBuilder().append(planetary, that.planetary).append(stationName, that.stationName).append(systemName, that.systemName).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(stationName).append(systemName).append(planetary).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("stationName", stationName)
                .append("systemName", systemName)
                .append("planetary", planetary)
                .toString();
    }
}
