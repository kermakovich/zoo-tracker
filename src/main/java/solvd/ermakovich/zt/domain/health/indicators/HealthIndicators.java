package solvd.ermakovich.zt.domain.health.indicators;

import lombok.Data;

/**
 * Represents animal health indicators.
 *
 * @author Ermakovich Kseniya
 */
@Data
public class HealthIndicators {

    /**
     * Heart rate.
     */
    private Integer heartRate;

    /**
     * Blood pressure.
     */
    private BloodPressure bloodPressure;

    /**
     * Body temperature.
     */
    private Float temperature;

}
