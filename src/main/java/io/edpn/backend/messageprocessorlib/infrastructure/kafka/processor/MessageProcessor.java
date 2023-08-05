package io.edpn.backend.messageprocessorlib.infrastructure.kafka.processor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;

public interface MessageProcessor<M> {

    void listen(JsonNode json) throws JsonProcessingException;

    void handle(M message);

    M processJson(JsonNode json) throws JsonProcessingException;
}
