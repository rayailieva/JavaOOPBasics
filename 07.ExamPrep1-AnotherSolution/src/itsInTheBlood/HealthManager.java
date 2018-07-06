package itsInTheBlood;

import itsInTheBlood.bloodcells.RedBloodCell;
import itsInTheBlood.bloodcells.WhiteBloodCell;
import itsInTheBlood.microbes.Bacteria;
import itsInTheBlood.microbes.Fungi;
import itsInTheBlood.microbes.Virus;

import java.util.LinkedHashMap;
import java.util.Map;

public class HealthManager {

   private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new LinkedHashMap<>();
    }


    public String checkCondition(String organismName){
        if(this.organisms.containsKey(organismName)){
            return this.organisms.get(organismName).toString();
        }
        return "";
    }

    public String createOrganism(String name) {
       if(this.organisms.containsKey(name)){
           return String.format("Organism %s already exists%n", name);
       }
           this.organisms.put(name, new Organism(name));
           return String.format("Created organism %s%n", name);
    }

    public String addCluster(String organismName, String id, int rows, int cols){
        if(organisms.containsKey(organismName)) {
            Cluster cluster = new Cluster(id, rows, cols);
            Organism organism = organisms.get(organismName);

            if(organism.getClusters().stream().noneMatch(x -> x.getId().equals(id))){
                organism.getClusters().add(cluster);
                return String.format("Organism %s: Created cluster %s%n", organismName, id);
            }
        }
        return "";
    }

    public String addCell(String organismName, String clusterId, String cellType,
                          String cellId, int health, int positionRow, int positionCol, int additionalProperty){
        Organism organism = organisms.get(organismName);

        if (this.organisms.containsKey(organismName)) {
            Cluster cluster = organism.getClusters().stream().filter(x -> x.getId().equals(clusterId)).findFirst().orElse(null);

            Cell cell = null;
            switch (cellType) {
                case "WhiteBloodCell":
                    cell = new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                case "RedBloodCell":
                    cell = new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                case "Virus":
                    cell = new Virus(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                case "Bacteria":
                    cell = new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                case "Fungi":
                    cell = new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                default:
                    break;
            }
            if (cell != null) {
                cluster.addCellToCluster(cell);
                return String.format("Organism %s: Created cell %s in cluster %s%n", organismName, cellId, clusterId);
            }
        }
        return "";
    }

    public String activateCluster(String organismName){
        if(this.organisms.containsKey(organismName)) {
            Organism organism = organisms.get(organismName);
            if (organism.getClusters().size() > 0) {
                Cluster cluster = organism.getClusters().get(0);
                cluster.activate();
                organism.getClusters().remove(0);
                organism.getClusters().add(cluster);
                return String.format("Organism %s: Activated cluster %s. Cells left: %s%n",
                        organism.getName(), cluster.getId(), cluster.getCells().size());
            }
        }
        return "";
    }

}
