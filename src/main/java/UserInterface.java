import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class UserInterface {
    Dealership dealership = DealershipFileManager.getDealership();
    ContractFileManager contractFileManager = new ContractFileManager();
    Scanner scanner = new Scanner(System.in);
    void display(){
        while (true){
            System.out.println("====Home Menu=====");
            System.out.println("1. Get Vehicles by Price");
            System.out.println("2. Get Vehicles by Make/Model");
            System.out.println("3. Get Vehicles by Year");
            System.out.println("4. Get Vehicles by Color");
            System.out.println("5. Get Vehicles by Mileage");
            System.out.println("6. Get Vehicles by Type");
            System.out.println("7. Display All Vehicles");
            System.out.println("8. Add Vehicle");
            System.out.println("9. Remove Vehicle");
            System.out.println("0. Exit");
            System.out.println("S. Sale");
            System.out.println("L. Lease");
            String userInput = scanner.nextLine();
            userInput = userInput.toUpperCase();
            switch (userInput){
                case "1":
                    System.out.println("Enter the Price Min: ");
                    double minPrice = Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter the Price Max: ");
                    double maxPrice = Double.parseDouble(scanner.nextLine());
                    dealership.getVehiclesByPrice(minPrice, maxPrice);
                    break;
                case "2":
                    System.out.println("The Vehicle Make: ");
                    String theMake = scanner.nextLine();
                    System.out.println("The Vehicle Model: ");
                    String theModel = scanner.nextLine();
                    dealership.getVehiclesByMakeModel(theMake, theModel);
                    break;
                case "3":
                    System.out.println("Enter the Min Year: ");
                    int minYear = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the Max Year: ");
                    int maxYear = Integer.parseInt(scanner.nextLine());
                    dealership.getVehiclesByYear(minYear, maxYear);
                    break;
                case "4":
                    System.out.println("Enter the Color: ");
                    dealership.getVehiclesByColor(scanner.nextLine());
                    break;
                case "5":
                    System.out.println("Enter the Min Mileage: ");
                    int minMile = Integer.parseInt(scanner.nextLine());
                    System.out.println("Enter the Max Mileage: ");
                    int maxMile = Integer.parseInt(scanner.nextLine());
                    dealership.getVehiclesByMileage(minMile, maxMile);
                    break;
                case "6":
                    System.out.println("Enter the Type of the Vehicle: ");
                    dealership.getVehiclesByType(scanner.nextLine());
                    break;
                case "7":
                    System.out.println("All Vehicle Display");
                    dealership.getAllVehicles();
                    break;
                case "8":
                    System.out.println("Enter VIN: ");
                    int vin = scanner.nextInt();
                    System.out.println("Enter Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter Make: ");
                    String make = scanner.nextLine();
                    System.out.println("Enter Model: ");
                    String model = scanner.nextLine();
                    System.out.println("Enter Vehicle Type: ");
                    String vehicleType = scanner.nextLine();
                    System.out.println("Enter Color: ");
                    String color = scanner.nextLine();
                    System.out.println("Enter Odometer: ");
                    int odometer = scanner.nextInt();
                    System.out.println("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                    System.out.println("Vehicle added.");
                    DealershipFileManager.writeVehicle(vehicle);
                    break;
                case "9":
                    List<Vehicle> vehiclesList = dealership.getAllVehicles();
                    System.out.println("Enter the Vehicle VIN Number you want to remove:");
                    int vinNumber = Integer.parseInt(scanner.nextLine());
                    Vehicle vehicleToRemove = null;
                    for (Vehicle vehicles : vehiclesList) {
                        if (vehicles.getVin() == vinNumber) {
                            vehicleToRemove = vehicles;
                            break;
                        }
                    }
                    if (vehicleToRemove != null) {
                        dealership.removeVehicle(vehicleToRemove);
                        DealershipFileManager.rewriteVehicle(vehiclesList);
                        System.out.println("Vehicle removed from inventory.");
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                    break;
                case "0":
                    System.exit(0);
                case "S":
                case "L":
                    break;
                default:
                    System.out.println("Error 404");
            }
        }
    }
}
