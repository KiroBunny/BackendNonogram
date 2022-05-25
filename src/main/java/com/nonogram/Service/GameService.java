package com.nonogram.Service;

import com.nonogram.Model.Game.ReferenceMap;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GameService {
    private ReferenceMap referenceMap;

    public GameService() {
        this(null);
    }

    public GameService(ReferenceMap referenceMap) {
        this.referenceMap = referenceMap;
    }

    public GameService(long panelID) {
        this.referenceMap = new ReferenceMap(panelID);
    }

    public boolean checkElement(List<Integer> cords) {
        int row = cords.get(0);
        int col = cords.get(1);
        return referenceMap.getReferencePanel().getValueAtIndex(row, col);
    }

    public ReferenceMap getReferenceMap() {
        return referenceMap;
    }

    public void setReferenceMap(ReferenceMap referenceMap) {
        this.referenceMap = referenceMap;
    }

    public String[] getRowTabOfTrue(Long mapPanelID) {
        return referenceMap.getRowTabOfTrue(mapPanelID);
    }

    public String[] getColTabOfTrue(Long mapPanelID) {
        return referenceMap.getColTabOfTrue(mapPanelID);
    }
}
