package io.edpn.backend.messageprocessorlib.application.dto.eddn.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class SystemDataRequest {

    @JsonProperty("requestingModule")
    private String requestingModule;
    @JsonProperty("systemName")
    private String systemName;

    public SystemDataRequest() {
    }

    public String getSystemName() {
        return this.systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getRequestingModule() {
        return requestingModule;
    }

    public void setRequestingModule(String requestingModule) {
        this.requestingModule = requestingModule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SystemDataRequest that = (SystemDataRequest) o;

        return new EqualsBuilder().append(systemName, that.systemName).append(requestingModule, that.requestingModule).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(systemName).append(requestingModule).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("systemName", systemName)
                .append("requestingModule", requestingModule)
                .toString();
    }
}
