package org.KrJr.model.population;

import org.KrJr.model.Planets.Planet;
import org.springframework.stereotype.Component;

@Component
public abstract class Population extends Planet {
    public long populationNumber;
    public abstract void action();
}
