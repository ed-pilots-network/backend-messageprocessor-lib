package io.edpn.backend.messageprocessorlib;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import io.edpn.backend.messageprocessorlib.application.dto.eddn.CommodityMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.edpn.backend.messageprocessorlib.EddnMessageTestHelper.deserialize;
import static io.edpn.backend.messageprocessorlib.EddnMessageTestHelper.readSampleJsonFiles;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommodityMessageTest {

    private static final String SAMPLES_DIRECTORY = "data/eddn-observed-messages/commodity/3_dir/";

    @ParameterizedTest
    @MethodSource
    public void commodityMessageV3Deserializes(JsonNode jsonNode) throws JsonProcessingException {
        CommodityMessage.V3 message = deserialize(jsonNode, CommodityMessage.V3.class);
        assertNotNull(message);
    }

    private static Stream<JsonNode> commodityMessageV3Deserializes() {
        return readSampleJsonFiles(SAMPLES_DIRECTORY);
    }
}
