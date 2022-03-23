package com.nonogram.Controller;

import com.nonogram.Model.Game.MapPanel;
import com.nonogram.Repositories.MapPanelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MapPanelController {
    private final MapPanelRepository mapPanelRepository;

    public MapPanelController(MapPanelRepository mapPanelRepository) {
        this.mapPanelRepository = mapPanelRepository;
    }

    @GetMapping("/games")
    public List<MapPanel> getMapPanels() {
        return (List<MapPanel>) mapPanelRepository.findAll();
    }

    @PostMapping("/myGame")
    public Optional<MapPanel> getMapPanel(@RequestBody Long mapPanelID) {
        return mapPanelRepository.findById(mapPanelID);
    }

}
