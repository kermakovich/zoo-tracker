package solvd.ermakovich.zt.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Represents zoo animal.
 *
 * @author Ermakovich Kseniya
 */
@Data
@Entity
@Table(name = "animals")
public class Animal {

    /**
     * Unique identifier.
     */
    @Id
    private Long id;

    /**
     * Animal name.
     */
    private String name;

    /**
     * Type.
     */
    private AnimalType type;

    /**
     * Animal description.
     */
    private String description;

}
