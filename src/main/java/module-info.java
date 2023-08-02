module edpn.backend.messageprocessorlib {
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires edpn.backend.util;

    exports io.edpn.backend.messageprocessorlib.application.dto.eddn;
    exports io.edpn.backend.messageprocessorlib.infrastructure.kafka.processor;
    exports io.edpn.backend.messageprocessorlib.application.dto.eddn.data;

    opens io.edpn.backend.messageprocessorlib.application.dto.eddn to com.fasterxml.jackson.databind;
}
