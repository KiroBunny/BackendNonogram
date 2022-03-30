package com.nonogram.Service;

import com.nonogram.Model.Game.ReferenceMap;
import org.springframework.stereotype.Service;

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

    public boolean checkElement(int row, int col) {
        return false;
    }

    public ReferenceMap getReferenceMap() {
        return referenceMap;
    }

    public void setReferenceMap(ReferenceMap referenceMap) {
        this.referenceMap = referenceMap;
    }
}
