package exam12Nov2017;

import exam12Nov2017.bloodcells.RedBloodCell;
import exam12Nov2017.bloodcells.WhiteBloodCell;
import exam12Nov2017.microbes.Bacteria;
import exam12Nov2017.microbes.Fungi;
import exam12Nov2017.microbes.Virus;

import java.util.ArrayList;
import java.util.List;

public class HealthManager {
    private List<Organism> organisms;

    public HealthManager() {
        this.setOrganisms(new ArrayList<>());
    }

    public List<Organism> getOrganisms() {
        return organisms;
    }

    private void setOrganisms(List<Organism> organisms) {
        this.organisms = organisms;
    }

    public String checkCondition(String organismName) {
        Organism organism = organisms.stream().filter(x -> x.getName().equals(organismName)).findFirst().orElse(null);
        return organism.toString();
    }

    public String createOrganism(String name) {
        if (this.getOrganisms().stream().anyMatch(x -> x.getName().equals(name))) {
            return String.format("Organism %s already exists%n", name);

        }
        this.getOrganisms().add(new Organism(name));
        return String.format("Created organism %s%n", name);
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        if (organisms.stream().anyMatch(x -> x.getName().equals(organismName))) {
            Organism organism = organisms.stream().filter(x -> x.getName().equals(organismName)).findFirst().orElse(null);
            if (organism.getClusters().stream().noneMatch(x -> x.getId().equals(id))) {
                organism.getClusters().add(new Cluster(id, rows, cols));
                return String.format("Organism %s: Created cluster %s%n", organismName, id);
            }
        }
        return "";
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        if (organisms.stream().anyMatch(x -> x.getName().equals(organismName))) {
            Organism organism = organisms.stream().filter(x -> x.getName().equals(organismName)).findFirst().orElse(null);
            if (organism.getClusters().stream().anyMatch(x -> x.getId().equals(clusterId))) {
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
                    cluster.addCell(cell);
                    return String.format("Organism %s: Created cell %s in cluster %s%n", organismName, cellId, clusterId);
                }
            }
        }
        return "";
    }

    public String activateCluster (String organismName){
        if (organisms.stream().anyMatch(x -> x.getName().equals(organismName))){
            Organism organism = organisms.stream().filter(x -> x.getName().equals(organismName)).findFirst().orElse(null);
            if (!organism.getClusters().isEmpty()){
                Cluster currentCluster = organism.getClusters().get(0);
                currentCluster.activate();
                organism.getClusters().remove(0);
                organism.getClusters().add(currentCluster);
                return String.format("Organism %s: Activated cluster %s. Cells left: %s%n",
                        organism.getName(), currentCluster.getId(), currentCluster.getCells().size());
            }
        }
        return "";
    }
}
