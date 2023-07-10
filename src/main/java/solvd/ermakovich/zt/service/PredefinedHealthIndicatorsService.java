package solvd.ermakovich.zt.service;

import solvd.ermakovich.zt.domain.health.indicators.DefaultHealthIndicators;

/**
 * Service that manages default health indicators.
 *
 * @author Ermakovich Kseniya
 */
public interface PredefinedHealthIndicatorsService {

    /**
     * Finds default health indicators by id.
     *
     * @param id unique identifier
     * @return default health indicators
     */
    DefaultHealthIndicators getById(String id);

}
