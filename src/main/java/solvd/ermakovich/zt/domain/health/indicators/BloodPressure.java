package solvd.ermakovich.zt.domain.health.indicators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Animal blood pressure.
 *
 * @author Ermakovich Kseniya
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodPressure {

    /**
     * Systolic part of blood pressure.
     */
    private Integer systolic;

    /**
     * Diastolic part of blood pressure.
     */
    private Integer diastolic;

}
