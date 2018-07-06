package itsInTheBlood;

import java.util.ArrayList;
import java.util.List;

public class Organism {
    private String name;
    private List<Cluster> clusters;

    public Organism(String name) {
        this.setName(name);
        this.setClusters(new ArrayList<>());
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    protected List<Cluster> getClusters() {
        return this.clusters;
    }

    private void setClusters(List<Cluster> clusters) {
        this.clusters = clusters;
    }

    private int findCellsCount() {
        int cellCount =0;
        for (Cluster cluster: clusters){
            cellCount += cluster.getCells().size();
        }
        return cellCount;
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append(String.format("Organism - %s", this.name)).append("\n");
       sb.append(String.format("--Clusters: %d", this.getClusters().size())).append("\n");
       sb.append(String.format("--Cells: %d", findCellsCount())).append("\n");

       for (Cluster cluster: clusters){
           sb.append(cluster.toString());
       }
       return sb.toString();
    }


}
