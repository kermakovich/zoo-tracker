package solvd.ermakovich.zt.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import solvd.ermakovich.zt.domain.health.indicators.DefaultHealthIndicators;
import solvd.ermakovich.zt.service.DefaultHealthIndicatorService;
import solvd.ermakovich.zt.web.dto.DefaultHealthIndicatorsDto;
import solvd.ermakovich.zt.web.mapper.DefaultHealthIndicatorMapper;

/**
 * @author Ermakovich Kseniya
 */
@RestController
@RequestMapping("/api/v1/indicators")
@RequiredArgsConstructor
public class IndicatorsController {

    private final DefaultHealthIndicatorMapper mapper;
    private final DefaultHealthIndicatorService healthIndicatorService;

    @GetMapping("/{id}")
    public DefaultHealthIndicatorsDto findById(
            final @PathVariable String id
    ) {
        DefaultHealthIndicators indicators =
                healthIndicatorService.getById(id);
        return mapper.toDto(indicators);
    }

}
