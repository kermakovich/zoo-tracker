package solvd.ermakovich.zt.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * @author Ermakovich Kseniya
 */
@Data
@Entity
@Table(name = "animals")
public class Animal {

    @Id
    private Long id;
    private String name;
    private AnimalType type;
    private String description;

}
