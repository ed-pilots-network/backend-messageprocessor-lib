package io.edpn.backend.messageprocessorlib.application.dto.eddn;

import java.time.LocalDateTime;

public interface TimestampedEddnMessage<P extends EddnMessage.Payload> extends EddnMessage<P> {

    LocalDateTime messageTimeStamp();

}
