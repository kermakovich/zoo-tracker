package solvd.ermakovich.zt.service;

import solvd.ermakovich.zt.domain.health.indicators.DefaultHealthIndicators;

/**
 * @author Ermakovich Kseniya
 */
public interface DefaultHealthIndicatorService {

    DefaultHealthIndicators getById(String id);

}
