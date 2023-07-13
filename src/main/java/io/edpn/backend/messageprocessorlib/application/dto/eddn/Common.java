package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public interface Common {
    class EddnMessageHeader {
        @JsonProperty("uploaderID")
        private String uploaderID;
        @JsonProperty("gameversion")
        private String gameVersion;
        @JsonProperty("gamebuild")
        private String gameBuild;
        @JsonProperty("softwareName")
        private String softwareName;
        @JsonProperty("softwareVersion")
        private String softwareVersion;
        @JsonProperty("gatewayTimestamp")
        private String gatewayTimestamp;

        public EddnMessageHeader() {
        }

        public String getUploaderID() {
            return this.uploaderID;
        }

        public String getGameVersion() {
            return this.gameVersion;
        }

        public String getGameBuild() {
            return this.gameBuild;
        }

        public String getSoftwareName() {
            return this.softwareName;
        }

        public String getSoftwareVersion() {
            return this.softwareVersion;
        }

        public String getGatewayTimestamp() {
            return this.gatewayTimestamp;
        }

        @JsonProperty("uploaderID")
        public void setUploaderID(String uploaderID) {
            this.uploaderID = uploaderID;
        }

        @JsonProperty("gameversion")
        public void setGameVersion(String gameVersion) {
            this.gameVersion = gameVersion;
        }

        @JsonProperty("gamebuild")
        public void setGameBuild(String gameBuild) {
            this.gameBuild = gameBuild;
        }

        @JsonProperty("softwareName")
        public void setSoftwareName(String softwareName) {
            this.softwareName = softwareName;
        }

        @JsonProperty("softwareVersion")
        public void setSoftwareVersion(String softwareVersion) {
            this.softwareVersion = softwareVersion;
        }

        @JsonProperty("gatewayTimestamp")
        public void setGatewayTimestamp(String gatewayTimestamp) {
            this.gatewayTimestamp = gatewayTimestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            EddnMessageHeader that = (EddnMessageHeader) o;

            return new EqualsBuilder().append(uploaderID, that.uploaderID).append(gameVersion, that.gameVersion).append(gameBuild, that.gameBuild).append(softwareName, that.softwareName).append(softwareVersion, that.softwareVersion).append(gatewayTimestamp, that.gatewayTimestamp).isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37).append(uploaderID).append(gameVersion).append(gameBuild).append(softwareName).append(softwareVersion).append(gatewayTimestamp).toHashCode();
        }

        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("uploaderID", uploaderID)
                    .append("gameVersion", gameVersion)
                    .append("gameBuild", gameBuild)
                    .append("softwareName", softwareName)
                    .append("softwareVersion", softwareVersion)
                    .append("gatewayTimestamp", gatewayTimestamp)
                    .toString();
        }
    }
}
