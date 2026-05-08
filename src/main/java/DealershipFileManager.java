import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    public static List<Vehicle> vehicles() {
        List<Vehicle> Vehicles = new ArrayList<>();

        
        try {
            FileReader fileReader = new FileReader("src/main/resources/products.csv");
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
                Vehicles.add(vehicles);
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("There was a problem reading the inventory file.");
        } catch (Exception ex) {
            System.out.println("Something went from with the file.");
        }

        return Vehicles;
    }
}
