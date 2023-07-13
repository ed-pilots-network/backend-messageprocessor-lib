package io.edpn.backend.messageprocessorlib.application.dto.eddn.data;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SystemCoordinatesResponse {
    private String systemName;
    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;

    public SystemCoordinatesResponse() {
    }

    public String getSystemName() {
        return this.systemName;
    }

    public double getXCoordinate() {
        return this.xCoordinate;
    }

    public double getYCoordinate() {
        return this.yCoordinate;
    }

    public double getZCoordinate() {
        return this.zCoordinate;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void setZCoordinate(double zCoordinate) {
        this.zCoordinate = zCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SystemCoordinatesResponse that = (SystemCoordinatesResponse) o;

        return new EqualsBuilder().append(xCoordinate, that.xCoordinate).append(yCoordinate, that.yCoordinate).append(zCoordinate, that.zCoordinate).append(systemName, that.systemName).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(systemName).append(xCoordinate).append(yCoordinate).append(zCoordinate).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("systemName", systemName)
                .append("xCoordinate", xCoordinate)
                .append("yCoordinate", yCoordinate)
                .append("zCoordinate", zCoordinate)
                .toString();
    }
}
