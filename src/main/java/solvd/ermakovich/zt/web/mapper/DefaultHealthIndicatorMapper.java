package solvd.ermakovich.zt.web.mapper;

import org.mapstruct.Mapper;
import solvd.ermakovich.zt.domain.health.indicators.DefaultHealthIndicators;
import solvd.ermakovich.zt.web.dto.DefaultHealthIndicatorsDto;

/**
 * Default health indicators mapper.
 *
 * @author Ermakovich Kseniya
 */
@Mapper(componentModel = "spring")
public interface DefaultHealthIndicatorMapper {

    /**
     * Maps entity to dto.
     *
     * @param indicators domain entity
     * @return default health indicators dto
     */
    DefaultHealthIndicatorsDto toDto(DefaultHealthIndicators indicators);

}
