import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {

    public static void writeContract(Vehicle vehicle){
        try{
            File file = new File("src/main/resources/vehicles.csv");
            FileWriter fileWriter = new FileWriter(file, true);

            if (file.length() > 0) {
                fileWriter.write(System.lineSeparator());
            }
            fileWriter.write(String.format("%d|%d|%s|%s|%s|%s|%d|%.2f", vehicle.getVin(), vehicle.getYear(), vehicle.getMake(),vehicle.getModel(),vehicle.getVehicleType(), vehicle.getColor(),
                    vehicle.getOdometer(), vehicle.getPrice()));
            fileWriter.close();
        }
        catch(IOException ex){
            System.out.println("Error writing to file.");
        }
    }
}
