package solvd.ermakovich.zt.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solvd.ermakovich.zt.domain.health.indicators.DefaultHealthIndicators;
import solvd.ermakovich.zt.service.PredefinedHealthIndicatorsService;
import solvd.ermakovich.zt.web.dto.DefaultHealthIndicatorsDto;
import solvd.ermakovich.zt.web.mapper.DefaultHealthIndicatorMapper;

/**
 * Default health indicator controller. Provides access to default
 * health indicators.
 *
 * @author Ermakovich Kseniya
 */
@RestController
@RequestMapping("/api/v1/indicators")
@RequiredArgsConstructor
public class IndicatorsController {

    /**
     * Dto mapper.
     */
    private final DefaultHealthIndicatorMapper mapper;

    /**
     * Service.
     */
    private final PredefinedHealthIndicatorsService healthIndicatorService;

    /**
     * Finds entity by id.
     *
     * @param id unique identifier
     * @return default health indicators dto
     */
    @GetMapping("/{id}")
    public DefaultHealthIndicatorsDto findById(
            final @PathVariable String id
    ) {
        DefaultHealthIndicators indicators =
                healthIndicatorService.getById(id);
        return mapper.toDto(indicators);
    }

}
