package com.nonogram.Model.Game;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MapPanel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int Size = 0;

    boolean[][] tab;
    static final String PATH_TO_FILE = "src/main/resources/MapPanels/";

    public MapPanel() {
    }

    public MapPanel(int Size) {
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

    public boolean getValueAtIndex(int row, int col){
        if (row < Size && col < Size) {
            return tab[row][col];
        }
        return false;
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
