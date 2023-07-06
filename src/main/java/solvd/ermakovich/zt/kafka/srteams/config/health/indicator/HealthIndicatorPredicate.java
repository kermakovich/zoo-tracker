package solvd.ermakovich.zt.kafka.srteams.config.health.indicator;

import java.util.List;
import java.util.function.BiPredicate;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.Predicate;
import org.springframework.stereotype.Service;
import solvd.ermakovich.zt.domain.health.indicators.DefaultHealthIndicators;
import solvd.ermakovich.zt.domain.health.indicators.HealthIndicatorsMessage;
import solvd.ermakovich.zt.service.DefaultHealthIndicatorService;

/**
 * @author Ermakovich Kseniya
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class HealthIndicatorPredicate
        implements Predicate<String, HealthIndicatorsMessage> {

    private final DefaultHealthIndicatorService indicatorService;
    private final List<BiPredicate<DefaultHealthIndicators,
            HealthIndicatorsMessage>> predicates;

    @Override
    @SneakyThrows
    public boolean test(final String key,
                        final HealthIndicatorsMessage value) {
        DefaultHealthIndicators defaultHealthIndicators =
                indicatorService.getById(
               value.getDefaultHealthIndicatorsId()
        );
       return predicates.stream()
               .anyMatch(predicate ->
                       !predicate.test(defaultHealthIndicators, value)
               );
    }

}

