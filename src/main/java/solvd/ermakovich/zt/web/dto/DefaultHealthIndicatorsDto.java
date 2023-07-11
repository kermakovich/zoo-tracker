package solvd.ermakovich.zt.web.dto;

import lombok.Data;
import solvd.ermakovich.zt.domain.AnimalType;
import solvd.ermakovich.zt.domain.health.indicators.HealthIndicators;

/**
 * Represents default health indicators DTO.
 *
 * @author Ermakovich Kseniya
 */
@Data
public class DefaultHealthIndicatorsDto {

    /**
     * Unique identifier.
     */
    private Long id;

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
