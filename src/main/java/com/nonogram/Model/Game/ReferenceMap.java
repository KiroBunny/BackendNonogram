package com.nonogram.Model.Game;

import com.sun.istack.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReferenceMap {

    private long panelID;
    private MapPanel referencePanel;

    public ReferenceMap() {
    }

    public ReferenceMap(MapPanel referencePanel) {
        this.referencePanel = referencePanel;
        this.panelID = referencePanel.getId();
    }

    public ReferenceMap(long panelID) {
        this.panelID = panelID;
    }

    public MapPanel readMapPanelFromFileForGivenID(@NotNull long panelID) {
        try {
            if (referencePanel == null) {
                referencePanel = new MapPanel();
            }
            File file = new File(MapPanel.PATH_TO_FILE + panelID + ".txt");
            Scanner sc = new Scanner(file);
            List<String> list = new ArrayList<>();
            String line;

            while (sc.hasNextLine()) {
                line = sc.nextLine();
                System.out.println(line);

                list.add(line);
            }
            convertTextToMapTable(list);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return referencePanel;
    }

    public MapPanel readMapPanelFromFile() {
        return readMapPanelFromFileForGivenID(panelID);
    }

    private void convertTextToMapTable(List<String> text) {
        int row = 0;
        int size = text.get(0).length();
        boolean value = false;
        referencePanel.setSize(size);
        referencePanel.createTab();
        for (String line: text) {
            for (int i = 0; i < size; i++) {
                if (line.charAt(i) > '0') {
                    value = true;
                }
                referencePanel.addTab(row, i, value);
            }
        }
    }

    public long getPanelID() {
        return panelID;
    }

    public void setPanelID(long panelID) {
        this.panelID = panelID;
    }

    public MapPanel getReferencePanel() {
        return referencePanel;
    }

    public void setReferencePanel(MapPanel referencePanel) {
        this.referencePanel = referencePanel;
    }
}
