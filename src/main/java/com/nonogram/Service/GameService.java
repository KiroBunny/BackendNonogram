package com.nonogram.Service;

import com.nonogram.Model.Game.ReferenceMap;

public class GameService {
    private final ReferenceMap referenceMap;

    public GameService(ReferenceMap referenceMap) {
        this.referenceMap = referenceMap;
    }

    public GameService(long panelID) {
        this.referenceMap = new ReferenceMap(panelID);
    }

    public boolean checkElement(int row, int col) {
        return false;
    }
}
