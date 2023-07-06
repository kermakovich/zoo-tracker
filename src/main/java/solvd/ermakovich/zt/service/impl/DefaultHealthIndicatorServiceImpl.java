package solvd.ermakovich.zt.service.impl;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.cactoos.Scalar;
import org.springframework.stereotype.Service;
import solvd.ermakovich.zt.domain.health.indicators.DefaultHealthIndicators;
import solvd.ermakovich.zt.service.DefaultHealthIndicatorService;

/**
 * @author Ermakovich Kseniya
 */
@Service
@RequiredArgsConstructor
public class DefaultHealthIndicatorServiceImpl
        implements DefaultHealthIndicatorService {

    private final Scalar<Map<String, DefaultHealthIndicators>>
            defaultHealthIndicators;

    @Override
    @SneakyThrows
    public DefaultHealthIndicators getById(final String id) {
        return defaultHealthIndicators.value().get(id);
    }

}
