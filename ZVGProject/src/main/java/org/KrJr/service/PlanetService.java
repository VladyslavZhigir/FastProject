package org.KrJr.service;

import org.KrJr.model.Planets.Planet;
import org.KrJr.repository.PlanetRepository;
import org.springframework.stereotype.Service;

@Service
public class PlanetService {

    private final PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

   public void save(String planetName) {
        planetRepository.save(planetName);
   }

   public Planet getPlanetById(Long id) {
       return planetRepository.findByPlanetId(id);
   }
}
