package solvd.ermakovich.zt.kafka.srteams.config.health.indicator.filter;

import java.util.function.BiPredicate;
import org.springframework.stereotype.Component;
import solvd.ermakovich.zt.domain.health.indicators.DefaultHealthIndicators;
import solvd.ermakovich.zt.domain.health.indicators.HealthIndicatorsMessage;

/**
 * Blood pressure filter for health indicators.
 *
 * @author Ermakovich Kseniya
 */
@Component
final class NormalBloodPressure implements
        BiPredicate<DefaultHealthIndicators, HealthIndicatorsMessage> {

    /**
     * Max percent that acceptable.
     */
    private static final Float CRITICAL_DIFFERENCE_PERCENT = 0.05f;

    @Override
    public boolean test(final DefaultHealthIndicators defaultHealthIndicators,
                        final HealthIndicatorsMessage indicators) {
        return Math.abs(1 - (float) indicators.getHealthIndicators()
                .getBloodPressure().getDiastolic()
                / defaultHealthIndicators.getHealthIndicators()
                .getBloodPressure().getDiastolic())
                < CRITICAL_DIFFERENCE_PERCENT
                && Math.abs(1 - (float) indicators.getHealthIndicators()
                .getBloodPressure().getSystolic()
                / defaultHealthIndicators.getHealthIndicators()
                .getBloodPressure().getSystolic())
                < CRITICAL_DIFFERENCE_PERCENT;
    }

}
