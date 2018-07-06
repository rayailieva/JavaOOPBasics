package exam05Jan2018;

import exam05Jan2018.colonists.Colonist;
import exam05Jan2018.colonists.Soldier;
import exam05Jan2018.colonists.engineers.HardwareEngineer;
import exam05Jan2018.colonists.engineers.SoftwareEngineer;
import exam05Jan2018.colonists.medics.GeneralPractitioner;
import exam05Jan2018.colonists.medics.Surgeon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] colonyData = scanner.nextLine().split(" ");
        int maxFamilyCount = Integer.parseInt(colonyData[0]);
        int maxFamilyCapacity = Integer.parseInt(colonyData[0]);

        Colony colony = new Colony(maxFamilyCount, maxFamilyCapacity);

        String input = scanner.nextLine();

        while (!input.equals("end")){
            String[] tokens = input.split(" ");

            String command = tokens[0];

            switch (command){
                case "insert":
                    String colonistClass = tokens[1];

                    Colonist colonist = null;
                    switch (colonistClass){
                        case "SoftwareEngineer":
                            colonist = new SoftwareEngineer(tokens[2],tokens[3], Integer.parseInt(tokens[4]),Integer.parseInt(tokens[5]));
                            break;
                        case "HardwareEngineer":
                            colonist = new HardwareEngineer(tokens[2],tokens[3], Integer.parseInt(tokens[4]),Integer.parseInt(tokens[5]));
                            break;
                        case "Soldier":
                            colonist = new Soldier(tokens[2],tokens[3], Integer.parseInt(tokens[4]),Integer.parseInt(tokens[5]));
                            break;
                        case "GeneralPractitioner":
                            colonist = new GeneralPractitioner(tokens[2],tokens[3], Integer.parseInt(tokens[4]),Integer.parseInt(tokens[5]), tokens[6]);
                            break;
                        case "Surgeon":
                            colonist = new Surgeon(tokens[2],tokens[3], Integer.parseInt(tokens[4]),Integer.parseInt(tokens[5]), tokens[6]);
                            break;
                    }

                    if(colonist != null){
                        colony.addColonist(colonist);
                    }
                    break;
                case "remove":
                    String modificator = tokens[1];
                    if(modificator.equals("family")){
                        colony.removeFamily(tokens[2]);
                    }else if(modificator.equals("colonist")){
                        colony.removeColonist(tokens[2], tokens[3]);
                    }
                    break;
                case "grow":
                    colony.grow(Integer.parseInt(tokens[1]));
                    break;
                case "potential":
                    colony.getPotential();
                    break;
                case "capacity":
                   colony.getCapacity();
                case "family":
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
