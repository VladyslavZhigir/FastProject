package org.KrJr.controller;

import org.KrJr.service.PlanetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlanetController {
    private final PlanetService planetService;

    public PlanetController(PlanetService planetService) {
        this.planetService = planetService;
    }

    @PostMapping("/{name}")
    public ResponseEntity<String> addPlanet(@PathVariable String name) {
        planetService.save(name);
        return ResponseEntity.ok("Planet saved: " + name);
    }

    @GetMapping("/{name}/action")
    public ResponseEntity<String> act(@PathVariable String name) {
        planetService.performAction(name);
        return ResponseEntity.ok("Action performed for " + name);
    }
}
