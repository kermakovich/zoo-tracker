package solvd.ermakovich.zt.domain.health.indicators;

import lombok.Data;
import solvd.ermakovich.zt.domain.AnimalType;

/**
 * @author Ermakovich Kseniya
 */
@Data
public class DefaultHealthIndicators {

    private String id;
    private String name;
    private AnimalType animalType;
    private HealthIndicators healthIndicators;

}
