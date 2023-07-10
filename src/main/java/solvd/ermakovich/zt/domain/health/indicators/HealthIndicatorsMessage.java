package solvd.ermakovich.zt.domain.health.indicators;

import lombok.Builder;
import lombok.Data;

/**
 * Represents message from Kafka topic that contains animal health indicators.
 *
 * @author Ermakovich Kseniya
 */
@Data
@Builder
public class HealthIndicatorsMessage {

    /**
     * Unique animal identifier.
     */
    private String animalId;

    /**
     * Unique predefined health indicators identifier.
     */
    private String defaultHealthIndicatorsId;

    /**
     * Unique identifier.
     */
    private HealthIndicators healthIndicators;

}
