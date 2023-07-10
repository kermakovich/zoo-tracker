package solvd.ermakovich.zt.kafka.srteams.config.health.indicator.filter;

import java.util.function.BiPredicate;
import org.springframework.stereotype.Component;
import solvd.ermakovich.zt.domain.health.indicators.DefaultHealthIndicators;
import solvd.ermakovich.zt.domain.health.indicators.HealthIndicatorsMessage;

/**
 * temperature filter for health indicators.
 *
 * @author Ermakovich Kseniya
 */
@Component
final class NormalTemperature implements
        BiPredicate<DefaultHealthIndicators, HealthIndicatorsMessage> {

    /**
     * Max percent that acceptable.
     */
    private static final Float CRITICAL_DIFFERENCE_PERCENT = 0.05f;

    @Override
    public boolean test(final DefaultHealthIndicators defaultHealthIndicators,
                        final HealthIndicatorsMessage indicators) {
        return Math.abs(1 - indicators.getHealthIndicators().getTemperature()
                / defaultHealthIndicators.getHealthIndicators()
                .getTemperature())
                < CRITICAL_DIFFERENCE_PERCENT;
    }

}
