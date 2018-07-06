package itsInTheBlood;

public abstract class Cell {
    private String id;
    private int health;
    private int positionRow;
    private int positionCol;

    public Cell(String id, int health, int positionRow, int positionCol) {
        this.id = id;
        this.health = health;
        this.positionRow = positionRow;
        this.positionCol = positionCol;
    }

    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public int getHealth() {
        return this.health;
    }

    private void setHealth(int health) {
        this.health = health;
    }

    public int getPositionRow() {
        return this.positionRow;
    }

    private void setPositionRow(int positionRow) {
        this.positionRow = positionRow;
    }

    public int getPositionCol() {
        return this.positionCol;
    }

    private void setPositionCol(int positionCol) {
        this.positionCol = positionCol;
    }

    public abstract int getEnergy();

    public void assimilatesCell(int health){
        this.setHealth(this.getHealth() + health);
    }

    public void reduceHealth(int damage){
        this.setHealth(this.getHealth() - damage);
    }

    public void changeCellPosition(int newRow, int newCol){
        this.setPositionRow(newRow);
        this.setPositionCol(newCol);
    }

    @Override
    public String toString() {
        return "";
    }
}
