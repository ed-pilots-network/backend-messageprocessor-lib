package io.edpn.backend.messageprocessorlib.application.dto.eddn.journal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.messageprocessorlib.application.dto.eddn.EddnMessage;
import io.edpn.backend.messageprocessorlib.application.dto.eddn.TimestampedEddnMessage;
import io.edpn.backend.util.TimestampConverter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface ScanMessage {
    
    String EVENT = "JournalScan";
    
    record V1 (
        @JsonProperty("$schemaRef") String schemaRef,
        @JsonProperty("header") EddnMessage.Header header,
        @JsonProperty("message") V1.Payload message) implements TimestampedEddnMessage<EddnMessage.Payload> {
        
        @Override
        public LocalDateTime messageTimeStamp() {
            return TimestampConverter.convertToLocalDateTime(message.timestamp);
        }
        
        @JsonIgnoreProperties(ignoreUnknown = true)
        public record Payload(
                //Star or Body
                @JsonProperty("DistanceFromArrivalLS") Double arrivalDistance,
                @JsonProperty("AxialTilt") Double axialTilt,
                @JsonProperty("WasDiscovered") Boolean discovered,
                @JsonProperty("WasMapped") Boolean mapped,
                @JsonProperty("BodyName") String name,
                @JsonProperty("BodyID") Long localID,
                @JsonProperty("Radius") Double radius,
                @JsonProperty("RotationPeriod") Double rotationPeriod,
                @JsonProperty("StarPos") Double[] starPos,
                @JsonProperty("SurfaceTemperature") Double surfaceTemperature,
                @JsonProperty("StarSystem") String system,
                @JsonProperty("SystemAddress") Long systemAddress,
                @JsonProperty("horizons") Boolean horizons,
                @JsonProperty("odyssey") Boolean odyssey,
                @JsonProperty("timestamp") String timestamp,
                
                //Body
                @JsonProperty("AscendingNode") Double ascendingNode,
                @JsonProperty("Atmosphere") String atmosphere,
                @JsonProperty("AtmosphereComposition") List<AtmosphericPercentage> atmosphereComposition,
                @JsonProperty("Composition") Map<String, Double> bodyComposition,
                @JsonProperty("Eccentricity") Double eccentricity,
                @JsonProperty("Landable") Boolean landable,
                @JsonProperty("MassEM") Double mass,
                @JsonProperty("Materials") List<MaterialsPercentage> materials,
                @JsonProperty("MeanAnomaly") Double meanAnomaly,
                @JsonProperty("OrbitalInclination") Double orbitalInclination,
                @JsonProperty("OrbitalPeriod") Double orbitalPeriod,
                //TODO @JsonProperty("Parents") @JsonIgnore List<Map<String, Integer>> parents,
                @JsonProperty("Periapsis") Double periapsis,
                @JsonProperty("PlanetClass") String planetClass,
                @JsonProperty("Rings") List<Ring> rings,
                @JsonProperty("SemiMajorAxis") Double semiMajorAxis,
                @JsonProperty("SurfaceGravity") Double surfaceGravity,
                @JsonProperty("SurfacePressure") Double surfacePressure,
                @JsonProperty("TerraformState") String terraformState,
                @JsonProperty("TidalLock") Boolean tidalLock,
                @JsonProperty("Volcanism") String volcanism,
                
                //Star
                @JsonProperty("AbsoluteMagnitude") Double absoluteMagnitude,
                @JsonProperty("Age_MY") Long age,
                @JsonProperty("Luminosity") String luminosity,
                @JsonProperty("StarType") String starType,
                @JsonProperty("StellarMass") Long stellarMass,
                @JsonProperty("Subclass") Integer subclass
        ) implements EddnMessage.Payload {
            
            @JsonProperty(value = "event", access = JsonProperty.Access.READ_ONLY)
            public String event() {
                return EVENT;
            }
            
            public record AtmosphericPercentage(
                    @JsonProperty("Name") String name,
                    @JsonProperty("Percent") Double percent
            ){}
            
            public record MaterialsPercentage(
                    @JsonProperty("Name") String name,
                    @JsonProperty("Percent") Double percent
            ){}
            
            public record Ring(
                    @JsonProperty("InnerRad") Long innerRadius,
                    @JsonProperty("MassMT") Long mass,
                    @JsonProperty("Name") String name,
                    @JsonProperty("OuterRad") Long outerRadius,
                    @JsonProperty("RingClass") String ringClass
            ){}
            
        }
    }
}
