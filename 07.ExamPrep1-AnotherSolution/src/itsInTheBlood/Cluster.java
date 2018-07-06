package itsInTheBlood;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public int getRows() {
        return this.rows;
    }

    private void setRows(int rows) {
        this.rows = rows;
    }

    public int getCols() {
        return this.cols;
    }

    private void setCols(int cols) {
        this.cols = cols;
    }

    public List<Cell> getCells() {
        return this.cells;
    }

    private void setCells(List<Cell> cells) {
        this.cells = cells;
    }

    public void sortCellsInCluster() {
        this.setCells(cells.stream().sorted(Comparator.comparing(Cell::getPositionRow)
                .thenComparing(Cell::getPositionCol)).collect(Collectors.toList()));
    }
    public void addCellToCluster(Cell cell) {
        this.cells.add(cell);
    }


    public void activate() {
        if (this.getCells().size() > 1) {
            sortCellsInCluster();
            while (this.getCells().size() > 1) {
                Cell currentCell = this.getCells().get(0);
                Cell nextCell = this.getCells().get(1);
                if (currentCell.getClass().getSimpleName().equals("WhiteBloodCell") ||
                        currentCell.getClass().getSimpleName().equals("RedBloodCell")){
                    currentCell.assimilatesCell(nextCell.getHealth());
                    currentCell.changeCellPosition(nextCell.getPositionRow(), nextCell.getPositionCol());
                    this.cells.remove(1);
                }else{
                    if (fightCells(currentCell, nextCell)){
                        currentCell.changeCellPosition(nextCell.getPositionRow(), nextCell.getPositionCol());
                        this.getCells().remove(1);
                    }else{
                        this.getCells().remove(0);
                    }
                }
            }
        }
    }


    private boolean fightCells(Cell currentCell, Cell nextCell){
        while (currentCell.getHealth() > 0 && nextCell.getHealth() > 0){
            nextCell.reduceHealth(currentCell.getEnergy());
            if (nextCell.getHealth() <= 0){
                break;
            }else{
                currentCell.reduceHealth(nextCell.getEnergy());
            }
        }
        return currentCell.getHealth() > 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("----Cluster %s", this.getId())).append("\n");
        sortCellsInCluster();
        for(Cell cell: cells){
            sb.append(cell.toString());
        }
        return sb.toString();
    }
}
