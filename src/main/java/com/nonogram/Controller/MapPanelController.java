package com.nonogram.Controller;

import com.nonogram.Model.Game.MapPanel;
import com.nonogram.Repositories.MapPanelRepository;
import com.nonogram.Service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class MapPanelController {
    private final MapPanelRepository mapPanelRepository;
    private GameService gameService;

    public MapPanelController(MapPanelRepository mapPanelRepository) {
        this.mapPanelRepository = mapPanelRepository;
    }

    @GetMapping("/games")
    public List<MapPanel> getMapPanels() {
        return (List<MapPanel>) mapPanelRepository.findAll();
    }

    @PostMapping("/game")
    public void setMapPanel(@RequestBody Long mapPanelID) {
       gameService = new GameService(mapPanelID);
    }

    public boolean checkElement(@RequestBody int row, @RequestBody int col){
        return gameService.checkElement(row, col);
    }

}
