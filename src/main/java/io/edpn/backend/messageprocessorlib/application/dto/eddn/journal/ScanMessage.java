package io.edpn.backend.messageprocessorlib.application.dto.eddn.journal;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.edpn.backend.messageprocessorlib.application.dto.eddn.Common;
import io.edpn.backend.util.TimestampConverter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface ScanMessage {
    class V1 {
        @JsonProperty("$schemaRef")
        private String schemaRef;
        @JsonProperty("header")
        private Common.EddnMessageHeader header;
        @JsonProperty("message")
        private ScanMessage.V1.Message message;
        
        public V1() {
        }
        
        public LocalDateTime getMessageTimeStamp() {
            return TimestampConverter.convertToLocalDateTime(message.getTimestamp());
        }
        
        public String getSchemaRef() {
            return this.schemaRef;
        }
        
        public Common.EddnMessageHeader getHeader() {
            return this.header;
        }
        
        public ScanMessage.V1.Message getMessage() {
            return this.message;
        }
        
        @JsonProperty("$schemaRef")
        public void setSchemaRef(String schemaRef) {
            this.schemaRef = schemaRef;
        }
        
        @JsonProperty("header")
        public void setHeader(Common.EddnMessageHeader header) {
            this.header = header;
        }
        
        @JsonProperty("message")
        public void setMessage(ScanMessage.V1.Message message) {
            this.message = message;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            
            if (o == null || getClass() != o.getClass()) return false;
            
            ScanMessage.V1 v1 = (ScanMessage.V1) o;
            
            return new EqualsBuilder().append(schemaRef, v1.schemaRef).append(header, v1.header).append(message, v1.message).isEquals();
        }
        
        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37).append(schemaRef).append(header).append(message).toHashCode();
        }
        
        @Override
        public String toString() {
            return new ToStringBuilder(this)
                    .append("schemaRef", schemaRef)
                    .append("header", header)
                    .append("message", message)
                    .toString();
        }
        
        public static class Message {
            
            //Star or Body
            @JsonProperty("DistanceFromArrivalLS")
            private Double arrivalDistance;
            @JsonProperty("AxialTilt")
            private Double axialTilt;
            @JsonProperty("WasDiscovered")
            private Boolean discovered;
            @JsonProperty("WasMapped")
            private Boolean mapped;
            @JsonProperty("BodyName")
            private String name;
            @JsonProperty("Body")
            private Long localID;
            @JsonProperty("Radius")
            private Double radius;
            @JsonProperty("RotationPeriod")
            private Double rotationPeriod;
            @JsonProperty("StarPos")
            private Double[] starPos;
            @JsonProperty("SurfaceTemperature")
            private Double surfaceTemperature;
            @JsonProperty("StarSystem")
            private String system;
            @JsonProperty("SystemAddress")
            private Long systemAddress;
            @JsonProperty("horizons")
            private Boolean horizons;
            @JsonProperty("odyssey")
            private Boolean odyssey;
            @JsonProperty("timestamp")
            private String timestamp;
            
            //Body
            @JsonProperty("AscendingNode")
            private Double ascendingNode;
            @JsonProperty("Atmosphere")
            private String atmosphere;
            
            //TODO: Review
            @JsonProperty("AtmosphericComposition")
            private Map<String, Double> atmosphericComposition;
            @JsonProperty("Composition")
            private Map<String, Double> bodyComposition;
            @JsonProperty("Eccentricity")
            private Double eccentricity;
            @JsonProperty("Landable")
            private Boolean landable;
            @JsonProperty("MassEM")
            private Double mass;
            
            //TODO: Review
            @JsonProperty("Materials")
            private Map<String, String> materials;
            @JsonProperty("MeanAnomaly")
            private Double meanAnomaly;
            @JsonProperty("OrbitalInclination")
            private Double orbitalInclination;
            @JsonProperty("OrbitalPeriod")
            private Double orbitalPeriod;
            
            //TODO: Review
            private Map<String, Integer> parents;
            @JsonProperty("Periapsis")
            private Double periapsis;
            @JsonProperty("PlanetClass")
            private String planetClass;
            @JsonProperty("Rings")
            private List<Ring> rings;
            @JsonProperty("SemiMajorAxis")
            private Double semiMajorAxis;
            @JsonProperty("SurfaceGravity")
            private Double surfaceGravity;
            @JsonProperty("SurfacePressure")
            private Double surfacePressure;
            @JsonProperty("TerraformState")
            private String terraformState;
            @JsonProperty("TidalLock")
            private Boolean tidalLock;
            @JsonProperty("Volcanism")
            private String volcanism;
            
            //Star
            @JsonProperty("AbsoluteMagnitude")
            private Double absoluteMagnitude;
            @JsonProperty("Age_MY")
            private Long age;
            @JsonProperty("Luminosity")
            private String luminosity;
            @JsonProperty("StellarMass")
            private Long stellarMass;
            @JsonProperty("Subclass")
            private Integer subclass;
            
            public Double getArrivalDistance() {
                return arrivalDistance;
            }
            
            public void setArrivalDistance(Double arrivalDistance) {
                this.arrivalDistance = arrivalDistance;
            }
            
            public Double getAxialTilt() {
                return axialTilt;
            }
            
            public void setAxialTilt(Double axialTilt) {
                this.axialTilt = axialTilt;
            }
            
            public Boolean getDiscovered() {
                return discovered;
            }
            
            public void setDiscovered(Boolean discovered) {
                this.discovered = discovered;
            }
            
            public Boolean getMapped() {
                return mapped;
            }
            
            public void setMapped(Boolean mapped) {
                this.mapped = mapped;
            }
            
            public String getName() {
                return name;
            }
            
            public void setName(String name) {
                this.name = name;
            }
            
            public Long getLocalID() {
                return localID;
            }
            
            public void setLocalID(Long localID) {
                this.localID = localID;
            }
            
            public Double getRadius() {
                return radius;
            }
            
            public void setRadius(Double radius) {
                this.radius = radius;
            }
            
            public Double getRotationPeriod() {
                return rotationPeriod;
            }
            
            public void setRotationPeriod(Double rotationPeriod) {
                this.rotationPeriod = rotationPeriod;
            }
            
            public Double[] getStarPos() {
                return starPos;
            }
            
            public void setStarPos(Double[] starPos) {
                this.starPos = starPos;
            }
            
            public Double getSurfaceTemperature() {
                return surfaceTemperature;
            }
            
            public void setSurfaceTemperature(Double surfaceTemperature) {
                this.surfaceTemperature = surfaceTemperature;
            }
            
            public String getSystem() {
                return system;
            }
            
            public void setSystem(String system) {
                this.system = system;
            }
            
            public Long getSystemAddress() {
                return systemAddress;
            }
            
            public void setSystemAddress(Long systemAddress) {
                this.systemAddress = systemAddress;
            }
            
            public Boolean getHorizons() {
                return horizons;
            }
            
            public void setHorizons(Boolean horizons) {
                this.horizons = horizons;
            }
            
            public Boolean getOdyssey() {
                return odyssey;
            }
            
            public void setOdyssey(Boolean odyssey) {
                this.odyssey = odyssey;
            }
            
            public String getTimestamp() {
                return timestamp;
            }
            
            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }
            
            public Double getAscendingNode() {
                return ascendingNode;
            }
            
            public void setAscendingNode(Double ascendingNode) {
                this.ascendingNode = ascendingNode;
            }
            
            public String getAtmosphere() {
                return atmosphere;
            }
            
            public void setAtmosphere(String atmosphere) {
                this.atmosphere = atmosphere;
            }
            
            public Map<String, Double> getAtmosphericComposition() {
                return atmosphericComposition;
            }
            
            public void setAtmosphericComposition(Map<String, Double> atmosphericComposition) {
                this.atmosphericComposition = atmosphericComposition;
            }
            
            public Map<String, Double> getBodyComposition() {
                return bodyComposition;
            }
            
            public void setBodyComposition(Map<String, Double> bodyComposition) {
                this.bodyComposition = bodyComposition;
            }
            
            public Double getEccentricity() {
                return eccentricity;
            }
            
            public void setEccentricity(Double eccentricity) {
                this.eccentricity = eccentricity;
            }
            
            public Boolean getLandable() {
                return landable;
            }
            
            public void setLandable(Boolean landable) {
                this.landable = landable;
            }
            
            public Double getMass() {
                return mass;
            }
            
            public void setMass(Double mass) {
                this.mass = mass;
            }
            
            public Map<String, String> getMaterials() {
                return materials;
            }
            
            public void setMaterials(Map<String, String> materials) {
                this.materials = materials;
            }
            
            public Double getMeanAnomaly() {
                return meanAnomaly;
            }
            
            public void setMeanAnomaly(Double meanAnomaly) {
                this.meanAnomaly = meanAnomaly;
            }
            
            public Double getOrbitalInclination() {
                return orbitalInclination;
            }
            
            public void setOrbitalInclination(Double orbitalInclination) {
                this.orbitalInclination = orbitalInclination;
            }
            
            public Double getOrbitalPeriod() {
                return orbitalPeriod;
            }
            
            public void setOrbitalPeriod(Double orbitalPeriod) {
                this.orbitalPeriod = orbitalPeriod;
            }
            
            public Map<String, Integer> getParents() {
                return parents;
            }
            
            public void setParents(Map<String, Integer> parents) {
                this.parents = parents;
            }
            
            public Double getPeriapsis() {
                return periapsis;
            }
            
            public void setPeriapsis(Double periapsis) {
                this.periapsis = periapsis;
            }
            
            public String getPlanetClass() {
                return planetClass;
            }
            
            public void setPlanetClass(String planetClass) {
                this.planetClass = planetClass;
            }
            
            public List<Ring> getRings() {
                return rings;
            }
            
            public void setRings(List<Ring> rings) {
                this.rings = rings;
            }
            
            public Double getSemiMajorAxis() {
                return semiMajorAxis;
            }
            
            public void setSemiMajorAxis(Double semiMajorAxis) {
                this.semiMajorAxis = semiMajorAxis;
            }
            
            public Double getSurfaceGravity() {
                return surfaceGravity;
            }
            
            public void setSurfaceGravity(Double surfaceGravity) {
                this.surfaceGravity = surfaceGravity;
            }
            
            public Double getSurfacePressure() {
                return surfacePressure;
            }
            
            public void setSurfacePressure(Double surfacePressure) {
                this.surfacePressure = surfacePressure;
            }
            
            public String getTerraformState() {
                return terraformState;
            }
            
            public void setTerraformState(String terraformState) {
                this.terraformState = terraformState;
            }
            
            public Boolean getTidalLock() {
                return tidalLock;
            }
            
            public void setTidalLock(Boolean tidalLock) {
                this.tidalLock = tidalLock;
            }
            
            public String getVolcanism() {
                return volcanism;
            }
            
            public void setVolcanism(String volcanism) {
                this.volcanism = volcanism;
            }
            
            public Double getAbsoluteMagnitude() {
                return absoluteMagnitude;
            }
            
            public void setAbsoluteMagnitude(Double absoluteMagnitude) {
                this.absoluteMagnitude = absoluteMagnitude;
            }
            
            public Long getAge() {
                return age;
            }
            
            public void setAge(Long age) {
                this.age = age;
            }
            
            public String getLuminosity() {
                return luminosity;
            }
            
            public void setLuminosity(String luminosity) {
                this.luminosity = luminosity;
            }
            
            public Long getStellarMass() {
                return stellarMass;
            }
            
            public void setStellarMass(Long stellarMass) {
                this.stellarMass = stellarMass;
            }
            
            public Integer getSubclass() {
                return subclass;
            }
            
            public void setSubclass(Integer subclass) {
                this.subclass = subclass;
            }
            
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Message message)) return false;
                return Objects.equals(arrivalDistance, message.arrivalDistance) && Objects.equals(axialTilt, message.axialTilt) && Objects.equals(discovered, message.discovered) && Objects.equals(mapped, message.mapped) && Objects.equals(name, message.name) && Objects.equals(localID, message.localID) && Objects.equals(radius, message.radius) && Objects.equals(rotationPeriod, message.rotationPeriod) && Arrays.equals(starPos, message.starPos) && Objects.equals(surfaceTemperature, message.surfaceTemperature) && Objects.equals(system, message.system) && Objects.equals(systemAddress, message.systemAddress) && Objects.equals(horizons, message.horizons) && Objects.equals(odyssey, message.odyssey) && Objects.equals(timestamp, message.timestamp) && Objects.equals(ascendingNode, message.ascendingNode) && Objects.equals(atmosphere, message.atmosphere) && Objects.equals(eccentricity, message.eccentricity) && Objects.equals(landable, message.landable) && Objects.equals(mass, message.mass) && Objects.equals(meanAnomaly, message.meanAnomaly) && Objects.equals(orbitalInclination, message.orbitalInclination) && Objects.equals(orbitalPeriod, message.orbitalPeriod) && Objects.equals(periapsis, message.periapsis) && Objects.equals(planetClass, message.planetClass) && Objects.equals(semiMajorAxis, message.semiMajorAxis) && Objects.equals(surfaceGravity, message.surfaceGravity) && Objects.equals(surfacePressure, message.surfacePressure) && Objects.equals(terraformState, message.terraformState) && Objects.equals(tidalLock, message.tidalLock) && Objects.equals(volcanism, message.volcanism) && Objects.equals(absoluteMagnitude, message.absoluteMagnitude) && Objects.equals(age, message.age) && Objects.equals(luminosity, message.luminosity) && Objects.equals(stellarMass, message.stellarMass) && Objects.equals(subclass, message.subclass);
            }
            
            @Override
            public int hashCode() {
                return Objects.hash(arrivalDistance, axialTilt, discovered, mapped, name, localID, radius, rotationPeriod, surfaceTemperature, system, systemAddress, horizons, odyssey, timestamp, ascendingNode, atmosphere, eccentricity, landable, mass, meanAnomaly, orbitalInclination, orbitalPeriod, periapsis, planetClass, semiMajorAxis, surfaceGravity, surfacePressure, terraformState, tidalLock, volcanism, absoluteMagnitude, age, luminosity, stellarMass, subclass);
            }
            
            @Override
            public String toString() {
                return new ToStringBuilder(this)
                        .append("arrivalDistance", arrivalDistance)
                        .append("axialTilt", axialTilt)
                        .append("discovered", discovered)
                        .append("mapped", mapped)
                        .append("name", name)
                        .append("localID", localID)
                        .append("radius", radius)
                        .append("rotationPeriod", rotationPeriod)
                        .append("starPos", starPos)
                        .append("surfaceTemperature", surfaceTemperature)
                        .append("system", system)
                        .append("systemAddress", systemAddress)
                        .append("horizons", horizons)
                        .append("odyssey", odyssey)
                        .append("timestamp", timestamp)
                        .append("ascendingNode", ascendingNode)
                        .append("atmosphere", atmosphere)
                        .append("atmosphericComposition", atmosphericComposition)
                        .append("bodyComposition", bodyComposition)
                        .append("eccentricity", eccentricity)
                        .append("landable", landable)
                        .append("mass", mass)
                        .append("materials", materials)
                        .append("meanAnomaly", meanAnomaly)
                        .append("orbitalInclination", orbitalInclination)
                        .append("orbitalPeriod", orbitalInclination)
                        .append("parents", parents)
                        .append("periapsis", periapsis)
                        .append("planetClass", planetClass)
                        .append("rings", rings)
                        .append("semiMajorAxis", semiMajorAxis)
                        .append("surfaceGravity", surfaceGravity)
                        .append("surfacePressure", surfacePressure)
                        .append("terraformState", terraformState)
                        .append("tidalLock", tidalLock)
                        .append("volcanism", volcanism)
                        .append("absoluteMagnitude", absoluteMagnitude)
                        .append("age", age)
                        .append("luminosity", luminosity)
                        .append("stellarMass", stellarMass)
                        .append("subclass", subclass)
                        .toString();
            }
        }
        
        public static class Ring {
            @JsonProperty("InnerRad")
            private Long innerRadius;
            @JsonProperty("MassMT")
            private Long mass;
            @JsonProperty("Name")
            private String name;
            @JsonProperty("OuterRad")
            private Long outerRadius;
            @JsonProperty("RingClass")
            private String ringClass;
            
            public Long getInnerRadius() {
                return innerRadius;
            }
            
            public void setInnerRadius(Long innerRadius) {
                this.innerRadius = innerRadius;
            }
            
            public Long getMass() {
                return mass;
            }
            
            public void setMass(Long mass) {
                this.mass = mass;
            }
            
            public String getName() {
                return name;
            }
            
            public void setName(String name) {
                this.name = name;
            }
            
            public Long getOuterRadius() {
                return outerRadius;
            }
            
            public void setOuterRadius(Long outerRadius) {
                this.outerRadius = outerRadius;
            }
            
            public String getRingClass() {
                return ringClass;
            }
            
            public void setRingClass(String ringClass) {
                this.ringClass = ringClass;
            }
            
            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Ring ring)) return false;
                return Objects.equals(innerRadius, ring.innerRadius) && Objects.equals(mass, ring.mass) && Objects.equals(name, ring.name) && Objects.equals(outerRadius, ring.outerRadius) && Objects.equals(ringClass, ring.ringClass);
            }
            
            @Override
            public int hashCode() {
                return Objects.hash(innerRadius, mass, name, outerRadius, ringClass);
            }
            
            @Override
            public String toString() {
                
                return new ToStringBuilder(this)
                        .append("innerRadius", innerRadius)
                        .append("mass", mass)
                        .append("name", name)
                        .append("outerRadius", outerRadius)
                        .append("ringClass", ringClass)
                        .toString();
            }
            
        }
    }
}
