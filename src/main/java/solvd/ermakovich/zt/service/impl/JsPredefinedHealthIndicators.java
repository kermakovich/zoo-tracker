package solvd.ermakovich.zt.service.impl;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.cactoos.Scalar;
import org.springframework.stereotype.Service;
import solvd.ermakovich.zt.domain.health.indicators.DefaultHealthIndicators;
import solvd.ermakovich.zt.service.PredefinedHealthIndicatorsService;

/**
 * @author Ermakovich Kseniya
 */
@Service
@RequiredArgsConstructor
public class JsPredefinedHealthIndicators
        implements PredefinedHealthIndicatorsService {

    /**
     * Predefined health indicators. Key is unique identifier,
     * value - {@code DefaultHealthIndicators}
     */
    private final Scalar<Map<String, DefaultHealthIndicators>>
            defaultHealthIndicators;

    @Override
    @SneakyThrows
    public DefaultHealthIndicators getById(final String id) {
        return defaultHealthIndicators.value().get(id);
    }

}
