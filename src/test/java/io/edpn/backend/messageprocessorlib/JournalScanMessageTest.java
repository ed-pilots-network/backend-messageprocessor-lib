package io.edpn.backend.messageprocessorlib;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import io.edpn.backend.messageprocessorlib.application.dto.eddn.journal.ScanMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.edpn.backend.messageprocessorlib.EddnMessageTestHelper.deserialize;
import static io.edpn.backend.messageprocessorlib.EddnMessageTestHelper.readSampleJsonFiles;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JournalScanMessageTest {
    
    private static final String SAMPLES_DIRECTORY = "data/eddn-observed-messages/journal/scan/";
    
    @ParameterizedTest
    @MethodSource
    public void fssSignalDiscoveredMessageV1Deserializes(JsonNode jsonNode) throws JsonProcessingException {
        ScanMessage.V1 message = deserialize(jsonNode, ScanMessage.V1.class);
        assertNotNull(message);
    }
    
    private static Stream<JsonNode> fssSignalDiscoveredMessageV1Deserializes() {
        return readSampleJsonFiles(SAMPLES_DIRECTORY);
    }
}
