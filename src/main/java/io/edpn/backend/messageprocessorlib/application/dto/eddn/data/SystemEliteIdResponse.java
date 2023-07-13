package io.edpn.backend.messageprocessorlib.application.dto.eddn.data;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SystemEliteIdResponse {
    private String systemName;
    private long eliteId;

    public SystemEliteIdResponse() {
    }

    public String getSystemName() {
        return this.systemName;
    }

    public long getEliteId() {
        return this.eliteId;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public void setEliteId(long eliteId) {
        this.eliteId = eliteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SystemEliteIdResponse that = (SystemEliteIdResponse) o;

        return new EqualsBuilder().append(eliteId, that.eliteId).append(systemName, that.systemName).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(systemName).append(eliteId).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("systemName", systemName)
                .append("eliteId", eliteId)
                .toString();
    }
}
