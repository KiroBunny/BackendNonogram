package com.nonogram.Controller;

import com.nonogram.Model.Game.MapPanel;
import com.nonogram.Model.Game.ReferenceMap;
import com.nonogram.Repositories.MapPanelRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MapPanelController {
    private final MapPanelRepository mapPanelRepository;
    private final ReferenceMap referenceMap;

    public MapPanelController(MapPanelRepository mapPanelRepository, ReferenceMap referenceMap) {
        this.mapPanelRepository = mapPanelRepository;
        this.referenceMap = referenceMap;
    }

    @GetMapping("/games")
    public List<MapPanel> getMapPanels() {
        return (List<MapPanel>) mapPanelRepository.findAll();
    }

    @PostMapping("/myGame")
    public void setMapPanel(@RequestBody Long mapPanelID) {
        referenceMap.setPanelID(mapPanelID);
        referenceMap.setReferencePanel( mapPanelRepository.findById(mapPanelID).get());

    }

}
