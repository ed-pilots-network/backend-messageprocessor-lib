package io.edpn.backend.messageprocessorlib;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.edpn.backend.messageprocessorlib.application.dto.eddn.EddnMessage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class EddnMessageTestHelper {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final ClassLoader CLASS_LOADER = EddnMessageTestHelper.class.getClassLoader();

    static <M extends EddnMessage<?>> M deserialize(JsonNode jsonNode, Class<M> messageClass) throws JsonProcessingException {
        return OBJECT_MAPPER.treeToValue(jsonNode, messageClass);
    }

    static Stream<JsonNode> readSampleJsonFiles(String directory) {
        List<String> sampleJsonFiles = findSampleJsonFiles(directory);
        return sampleJsonFiles.stream().map(EddnMessageTestHelper::readSampleJsonFile);
    }

    private static List<String> findSampleJsonFiles(String directory) {
        try (InputStream inputStream = CLASS_LOADER.getResourceAsStream(directory);
             BufferedReader directoryReader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)))) {
            String delimiter = directory.endsWith("/") ? "" : "/";
            return directoryReader.lines()
                    .filter(fileName -> fileName.endsWith(".json"))
                    .map(fileName -> String.join(delimiter, directory, fileName))
                    .toList();
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read sample JSON files from directory: " + directory, e);
        }
    }

    private static JsonNode readSampleJsonFile(String path) {
        try (InputStream inputStream = CLASS_LOADER.getResourceAsStream(path);
             BufferedReader fileReader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(inputStream)))) {
            return OBJECT_MAPPER.readTree(fileReader);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to read sample JSON file: " + path);
        }
    }
}
