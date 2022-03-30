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

    public boolean checkElementForString(String rowCol) {
        int c = rowCol.indexOf("-");
        int row = Integer.parseInt(rowCol.substring(0, c));
        int col = Integer.parseInt(rowCol.substring(c+1));
        return referenceMap.getReferencePanel().getValueAtIndex(row, col);
    }

    public boolean checkElement(int row, int col) {
        return referenceMap.getReferencePanel().getValueAtIndex(row, col);
    }

    public ReferenceMap getReferenceMap() {
        return referenceMap;
    }

    public void setReferenceMap(ReferenceMap referenceMap) {
        this.referenceMap = referenceMap;
    }
}
