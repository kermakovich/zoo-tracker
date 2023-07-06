package solvd.ermakovich.zt.domain.health.indicators;

import lombok.Builder;
import lombok.Data;

/**
 * @author Ermakovich Kseniya
 */
@Data
@Builder
public class HealthIndicatorsMessage {

    private String animalId;
    private String defaultHealthIndicatorsId;
    private HealthIndicators healthIndicators;

}
