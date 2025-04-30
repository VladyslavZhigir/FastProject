package org.KrJr.model.Planets;

import jakarta.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.stereotype.Component;

@Component
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Earth extends Planet{

}
