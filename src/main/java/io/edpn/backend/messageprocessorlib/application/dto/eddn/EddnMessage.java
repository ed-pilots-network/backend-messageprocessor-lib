package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface EddnMessage<P extends EddnMessage.Payload> {

    String schemaRef();

    Header header();

    P message();

    record Header(
            @JsonProperty("uploaderID") String uploaderID,
            @JsonProperty("gameversion") String gameVersion,
            @JsonProperty("gamebuild") String gameBuild,
            @JsonProperty("softwareName") String softwareName,
            @JsonProperty("softwareVersion") String softwareVersion,
            @JsonProperty("gatewayTimestamp") String gatewayTimestamp
    ) {}

    interface Payload {}

}
