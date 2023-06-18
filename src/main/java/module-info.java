module io.edpn.backend.messageprocessor.lib {
    requires lombok;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires io.edpn.backend.util;

    exports io.edpn.backend.messageprocessorlib.application.dto.eddn;
    exports io.edpn.backend.messageprocessorlib.infrastructure.kafka.processor;
    exports io.edpn.backend.messageprocessorlib.application.dto.eddn.data;
}
