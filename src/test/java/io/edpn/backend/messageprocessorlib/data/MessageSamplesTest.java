package io.edpn.backend.messageprocessorlib.data;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class MessageSamplesTest {

    @Test
    public void readsApproachSettlementsSamples() {
        Set<JsonNode> samples = MessageSamples.ApproachSettlement.samples();
        assertFalse(samples.isEmpty());
    }

}
