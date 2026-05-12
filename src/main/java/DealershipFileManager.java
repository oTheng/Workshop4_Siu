import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {
    public static Dealership getDealership() {
        Dealership dealership = null;
        try {
            dealership = new Dealership();
            FileReader fileReader = new FileReader("src/main/resources/vehicles.csv");
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                int vin = Integer.parseInt(parts[0]);
                int year = Integer.parseInt(parts[1]);
                String make = parts[2];
                String model = parts[3];
                String vehicleType = parts[4];
                String color = parts[5];
                int odometer = Integer.parseInt(parts[6]);
                double price = Double.parseDouble(parts[7]);
                Vehicle vehicles = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(vehicles);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("There was a problem reading the inventory file.");
        } catch (Exception ex) {
            System.out.println("Something went from with the file.");
        }
        return dealership;
    }
    public static void writeVehicle(Vehicle vehicle){
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
    public static void rewriteVehicle(List<Vehicle> vehicles) {
        try (FileWriter writer = new FileWriter("src/main/resources/vehicles.csv")) {
            for (int i = 0; i < vehicles.size(); i++) {
                Vehicle vehicle = vehicles.get(i);

                writer.write(vehicle.getVin() + "|"
                        + vehicle.getYear() + "|"
                        + vehicle.getMake() + "|"
                        + vehicle.getModel() + "|"
                        + vehicle.getVehicleType() + "|"
                        + vehicle.getColor() + "|"
                        + vehicle.getOdometer() + "|"
                        + vehicle.getPrice());

                if (i < vehicles.size() - 1) {
                    writer.write("\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error rewriting vehicles.csv");
        }
    }
}
