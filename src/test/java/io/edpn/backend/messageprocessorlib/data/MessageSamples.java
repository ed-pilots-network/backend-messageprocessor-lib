package io.edpn.backend.messageprocessorlib.data;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class MessageSamples {

    private static final String OBSERVED_MESSAGES_PATH = "data/eddn-observed-messages/";
    private static final ClassLoader CLASS_LOADER = ApproachSettlement.class.getClassLoader();
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private static Set<String> findSampleFiles(String samplesPath) {
        Set<String> sampleFiles = new HashSet<>();
        try (InputStream in = CLASS_LOADER.getResourceAsStream(samplesPath)) {
            Objects.requireNonNull(in, "Unable to read JSON sample directory.");
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            for (String fileName = reader.readLine(); fileName != null; fileName = reader.readLine()) {
                if (fileName.endsWith(".json")) {
                    sampleFiles.add(samplesPath + fileName);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read JSON sample directory.", e);
        }
        return sampleFiles;
    }

    private static JsonNode readSampleFile(String resourcePath) {
        try (InputStream in = CLASS_LOADER.getResourceAsStream(resourcePath)) {
            Objects.requireNonNull(in, "Unable to read JSON sample file: " + resourcePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            return OBJECT_MAPPER.readTree(reader);
        } catch (IOException e) {
            throw new IllegalStateException("Unable to read JSON sample file: " + resourcePath, e);
        }
    }

    public static class ApproachSettlement {

        private static final String SAMPLES_PATH = OBSERVED_MESSAGES_PATH + "approachsettlement/1_dir/";

        public static Set<JsonNode> samples() {
            Set<String> sampleFiles = findSampleFiles(SAMPLES_PATH);
            if (sampleFiles.isEmpty()) {
                throw new IllegalStateException("No JSON sample files found.");
            }
            return sampleFiles.stream()
                    .map(MessageSamples::readSampleFile)
                    .collect(Collectors.toSet());
        }

    }

}
