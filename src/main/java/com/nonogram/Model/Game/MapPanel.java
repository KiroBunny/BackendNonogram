package com.nonogram.Model.Game;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MapPanel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int Size = 0;

    boolean[][] tab;
    static final String PATH_TO_FILE = "src/main/resources/MapPanels/";

    public MapPanel() {
    }

    public MapPanel(int xSize) {
        this.Size = Size;
        createTab();
    }

    public void createTab() {
        tab = new boolean[Size][Size];
    }

    public void addTab(int row, int col, boolean value) {
        if (row < Size && col < Size){
            tab[row][col] = value;
        }
    }

    public long getId() {
        return id;
    }

    public int getSize() {
        return Size;
    }

    public void setSize(int Size) {
        this.Size = Size;
    }

    public boolean[][] getTab() {
        return tab;
    }

    public void setTab(boolean[][] tab) {
        this.tab = tab;
    }
}
