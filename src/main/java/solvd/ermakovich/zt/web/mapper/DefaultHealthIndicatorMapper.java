package solvd.ermakovich.zt.web.mapper;

import org.mapstruct.Mapper;
import solvd.ermakovich.zt.domain.health.indicators.DefaultHealthIndicators;
import solvd.ermakovich.zt.web.dto.DefaultHealthIndicatorsDto;

/**
 * @author Ermakovich Kseniya
 */
@Mapper(componentModel = "spring")
public interface DefaultHealthIndicatorMapper {

    DefaultHealthIndicators toEntity(DefaultHealthIndicatorsDto dto);

    DefaultHealthIndicatorsDto toDto(DefaultHealthIndicators indicators);

}
