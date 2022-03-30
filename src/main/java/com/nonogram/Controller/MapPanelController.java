package com.nonogram.Controller;

import com.nonogram.Model.Game.MapPanel;
import com.nonogram.Model.Game.ReferenceMap;
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

    @GetMapping("/game/{id}")
    public MapPanel getMyMapPanel(@PathVariable("id") Long mapPanelID) {
        return mapPanelRepository.findById(mapPanelID).get();
    }

    @PostMapping("/game/{id}")
    public void setMyMapPanel(@PathVariable("id") Long mapPanelID) {
       gameService = new GameService( new ReferenceMap(mapPanelRepository.findById(mapPanelID).get()));
    }
/*
    @RequestMapping(path = "/game/{id}/{row-col}", method = RequestMethod.GET)
    public boolean checkElementForString(@PathVariable("id") Long mapPanelID, @PathVariable("row-col") String row_col){
        gameService = new GameService( new ReferenceMap(mapPanelRepository.findById(mapPanelID).get()));
        return gameService.checkElementForString(row_col);
    }*/

    @RequestMapping(path = "/game/{id}/{row}/{col}", method = RequestMethod.GET)
    public boolean checkElement(@PathVariable("id") Long mapPanelID, @PathVariable("row") int row,  @PathVariable("col") int col){
        gameService = new GameService( new ReferenceMap(mapPanelRepository.findById(mapPanelID).get()));
        return gameService.checkElement(row, col);
    }

}
