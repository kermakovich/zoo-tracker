package solvd.ermakovich.zt.helper;

import org.junit.jupiter.api.BeforeAll;
import solvd.ermakovich.zt.domain.health.indicators.BloodPressure;
import solvd.ermakovich.zt.domain.health.indicators.HealthIndicators;
import solvd.ermakovich.zt.domain.health.indicators.HealthIndicatorsMessage;

/**
 * @author Ermakovich Kseniya
 */
@SuppressWarnings("JTCOP.RuleAllTestsHaveProductionClass")
public class BaseTest {

    protected static HealthIndicatorsMessage goodHealthIndicatorsMessage;
    protected static HealthIndicatorsMessage badHealthIndicatorsMessage;


    @BeforeAll
    static void goodHealthIndicatorsMessageSetup() {
        HealthIndicators healthIndicators = new HealthIndicators();
        healthIndicators.setTemperature(40.4f);
        healthIndicators.setHeartRate(140);
        healthIndicators.setBloodPressure(new BloodPressure(150, 100));
        goodHealthIndicatorsMessage = HealthIndicatorsMessage
                .builder()
                .animalId("537f6038-1efe-11ee-be56-0242ac120002")
                .defaultHealthIndicatorsId("bd6e8290-1bec-11ee-be56-0242ac120002")
                .healthIndicators(healthIndicators)
                .build();
    }

    @BeforeAll
    static void badHealthIndicatorsMessageSetup() {
        HealthIndicators healthIndicators = new HealthIndicators();
        healthIndicators.setTemperature(40.4f);
        healthIndicators.setHeartRate(148);
        healthIndicators.setBloodPressure(new BloodPressure(150, 100));
        badHealthIndicatorsMessage = HealthIndicatorsMessage
                .builder()
                .animalId("537f6038-1efe-11ee-be56-0242ac120002")
                .defaultHealthIndicatorsId("bd6e8290-1bec-11ee-be56-0242ac120002")
                .healthIndicators(healthIndicators)
                .build();
    }

}
