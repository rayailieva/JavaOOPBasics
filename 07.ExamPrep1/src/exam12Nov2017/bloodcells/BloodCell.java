package exam12Nov2017.bloodcells;

import exam12Nov2017.Cell;

public abstract class BloodCell extends Cell {
    public BloodCell(String id, int health, int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }

    @Override
    public String toString() {
        return "BloodCell{}";
    }
}
