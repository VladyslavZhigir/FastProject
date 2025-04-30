package org.KrJr.model.Planets;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planetId;

    private String name;

    public void action(String name) {
        switch (name) {
            case "Earth":
                System.out.println("I'm from Earth");
                break;
                case "Mars":
                    System.out.println("I'm from Mars");
                    break;
            default:
                System.out.println("I'm from Planet");
                break;
        }
    }
}
