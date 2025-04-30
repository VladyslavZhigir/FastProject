package org.KrJr.repository;

import org.KrJr.model.Planets.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long> {
        Planet save(String planet);
        Planet findByNameIgnoreCase(String name);

        Planet findByPlanetId(Long planetId);
}
