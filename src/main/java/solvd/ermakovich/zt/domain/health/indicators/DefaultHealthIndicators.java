package solvd.ermakovich.zt.domain.health.indicators;

import lombok.Data;
import solvd.ermakovich.zt.domain.AnimalType;

/**
 * Predefined animal health indicators.
 *
 * @author Ermakovich Kseniya
 */
@Data
public class DefaultHealthIndicators {

    /**
     * Unique identifier.
     */
    private String id;

    /**
     * Default health indicators name.
     */
    private String name;

    /**
     * Animal type.
     */
    private AnimalType animalType;

    /**
     * Default values for health indicators.
     */
    private HealthIndicators healthIndicators;

}
