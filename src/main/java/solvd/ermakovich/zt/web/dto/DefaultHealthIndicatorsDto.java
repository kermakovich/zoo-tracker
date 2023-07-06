package solvd.ermakovich.zt.web.dto;

import lombok.Data;
import solvd.ermakovich.zt.domain.AnimalType;

/**
 * @author Ermakovich Kseniya
 */
@Data
public class DefaultHealthIndicatorsDto {

    private Long id;
    private String name;
    private AnimalType animalType;
    private Integer heartRate;
    private Integer bloodPressureSystolic;
    private Integer bloodPressureDiastolic;
    private Float temperature;

}
