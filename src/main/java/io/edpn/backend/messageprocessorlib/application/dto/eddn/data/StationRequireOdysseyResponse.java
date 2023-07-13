package io.edpn.backend.messageprocessorlib.application.dto.eddn.data;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class StationRequireOdysseyResponse {
    @JsonProperty("stationName")
    private String stationName;
    @JsonProperty("systemName")
    private String systemName;
    @JsonProperty("requireOdyssey")
    private boolean requireOdyssey;

    public StationRequireOdysseyResponse() {
    }

    public String getStationName() {
        return this.stationName;
    }

    public String getSystemName() {
        return this.systemName;
    }

    public boolean isRequireOdyssey() {
        return this.requireOdyssey;
    }

    @JsonProperty("stationName")
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    @JsonProperty("systemName")
    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    @JsonProperty("requireOdyssey")
    public void setRequireOdyssey(boolean requireOdyssey) {
        this.requireOdyssey = requireOdyssey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        StationRequireOdysseyResponse that = (StationRequireOdysseyResponse) o;

        return new EqualsBuilder().append(requireOdyssey, that.requireOdyssey).append(stationName, that.stationName).append(systemName, that.systemName).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(stationName).append(systemName).append(requireOdyssey).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("stationName", stationName)
                .append("systemName", systemName)
                .append("requireOdyssey", requireOdyssey)
                .toString();
    }
}
