import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public Dealership(){
        this.inventory = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesByPrice(double min, double max){
        if(min > max){
            System.out.println("Min can not be bigger than max");
        } else{
            for(Vehicle vehicles: inventory){
                if (vehicles.getPrice() >= min && vehicles.getPrice() <= max){
                    System.out.printf("Vin: %d Year: %d Make: %s Model: %s Vehicle Type: %s Color: %s Odometer: %d Price: %f %n", vehicles.getVin(), vehicles.getYear(),
                            vehicles.getMake(), vehicles.getModel(),vehicles.getVehicleType(),vehicles.getColor(),vehicles.getOdometer(), vehicles.getPrice());
                }
            }
        }
        return inventory;
    }
    public List<Vehicle> getVehiclesByMakeModel(String make, String model){
        for(Vehicle vehicles: inventory){
            if(Objects.equals(vehicles.getMake(), make) && Objects.equals(vehicles.getModel(), model)){
                System.out.printf("Vin: %d Year: %d Make: %s Model: %s Vehicle Type: %s Color: %s Odometer: %d Price: %f %n", vehicles.getVin(), vehicles.getYear(),
                        vehicles.getMake(), vehicles.getModel(),vehicles.getVehicleType(),vehicles.getColor(),vehicles.getOdometer(), vehicles.getPrice());
            }
        }
        return inventory;
    }
    public List<Vehicle> getVehiclesByYear(int min, int max){
        if(min > max){
            System.out.println("Min can not be bigger than max");
        } else{
            for(Vehicle vehicles: inventory){
                if (vehicles.getYear() >= min && vehicles.getYear() <= max){
                    System.out.printf("Vin: %d Year: %d Make: %s Model: %s Vehicle Type: %s Color: %s Odometer: %d Price: %f %n", vehicles.getVin(), vehicles.getYear(),
                            vehicles.getMake(), vehicles.getModel(),vehicles.getVehicleType(),vehicles.getColor(),vehicles.getOdometer(), vehicles.getPrice());
                }
            }
        }
        return inventory;
    }
    public List<Vehicle> getVehiclesByColor(String color){
        for(Vehicle vehicles: inventory){
            if(Objects.equals(vehicles.getColor(), color)){
                System.out.printf("Vin: %d Year: %d Make: %s Model: %s Vehicle Type: %s Color: %s Odometer: %d Price: %f %n", vehicles.getVin(), vehicles.getYear(),
                        vehicles.getMake(), vehicles.getModel(),vehicles.getVehicleType(),vehicles.getColor(),vehicles.getOdometer(), vehicles.getPrice());
            }
        }
        return inventory;
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max){
        if(min > max){
            System.out.println("Min can not be bigger than max");
        } else{
            for(Vehicle vehicles: inventory){
                if (vehicles.getOdometer() >= min && vehicles.getOdometer() <= max){
                    System.out.printf("Vin: %d Year: %d Make: %s Model: %s Vehicle Type: %s Color: %s Odometer: %d Price: %f %n", vehicles.getVin(), vehicles.getYear(),
                            vehicles.getMake(), vehicles.getModel(),vehicles.getVehicleType(),vehicles.getColor(),vehicles.getOdometer(), vehicles.getPrice());
                }
            }
        }
        return inventory;
    }
    public List<Vehicle> getVehiclesByType(String type){
        for(Vehicle vehicles: inventory){
            if(Objects.equals(vehicles.getVehicleType(), type)){
                System.out.printf("Vin: %d Year: %d Make: %s Model: %s Vehicle Type: %s Color: %s Odometer: %d Price: %f %n", vehicles.getVin(), vehicles.getYear(),
                        vehicles.getMake(), vehicles.getModel(),vehicles.getVehicleType(),vehicles.getColor(),vehicles.getOdometer(), vehicles.getPrice());
            }
        }
        return inventory;
    }
    public List<Vehicle> getAllVehicles(){
        for(Vehicle vehicles: inventory){
            System.out.printf("Vin: %d Year: %d Make: %s Model: %s Vehicle Type: %s Color: %s Odometer: %d Price: %f %n", vehicles.getVin(), vehicles.getYear(),
                    vehicles.getMake(), vehicles.getModel(),vehicles.getVehicleType(),vehicles.getColor(),vehicles.getOdometer(), vehicles.getPrice());
        }
        return inventory;
    }
    public void addVehicle(Vehicle vehicles) {
        inventory.add(vehicles);
    }
    public void removeVehicle(Vehicle vehicle){
        inventory.remove(vehicle);
    }
}

