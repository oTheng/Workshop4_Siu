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
                    List<Vehicle> vehiclesList1 = dealership.getAllVehicles();

                    System.out.println("Enter the Vehicle VIN Number you want to buy:");
                    int saleVin = Integer.parseInt(scanner.nextLine());

                    Vehicle vehicleToBuy = null;

                    for (Vehicle vehicleItem : vehiclesList1) {
                        if (vehicleItem.getVin() == saleVin) {
                            vehicleToBuy = vehicleItem;
                            break;
                        }
                    }

                    if (vehicleToBuy != null) {
                        System.out.println("Enter customer name:");
                        String customerName = scanner.nextLine();

                        System.out.println("Enter customer email:");
                        String customerEmail = scanner.nextLine();

                        System.out.println("Enter date of contract:");
                        String customerDate = scanner.nextLine();

                        System.out.println("Finance? YES or NO:");
                        String financeInput = scanner.nextLine().toUpperCase();
                        boolean finance = financeInput.equals("YES") || financeInput.equals("Y");

                        double loanAmount = 0;

                        if (finance) {
                            System.out.println("Enter loan amount:");
                            loanAmount = Double.parseDouble(scanner.nextLine());
                        }

                        SalesContract salesContract = new SalesContract(
                                customerDate,
                                customerName,
                                customerEmail,
                                vehicleToBuy,
                                finance,
                                loanAmount
                        );

                        contractFileManager.saveContract(salesContract);

                        vehiclesList1.remove(vehicleToBuy);

                        DealershipFileManager.rewriteVehicle(vehiclesList1);
                        System.out.println("Vehicle has been sold and contract saved.");
                    } else {
                        System.out.println("Vehicle not found.");
                    }

                    break;
                case "L":
                    List<Vehicle> vehiclesList2 = dealership.getAllVehicles();

                    System.out.println("Enter the Vehicle VIN Number you want to lease:");
                    int leaseVin = Integer.parseInt(scanner.nextLine());

                    Vehicle vehicleToLease = null;
                    int indexToRemove = -1;

                    for (int i = 0; i < vehiclesList2.size(); i++) {
                        if (vehiclesList2.get(i).getVin() == leaseVin) {
                            vehicleToLease = vehiclesList2.get(i);
                            indexToRemove = i;
                            break;
                        }
                    }

                    if (vehicleToLease != null) {
                        System.out.println("Enter customer name:");
                        String customerName = scanner.nextLine();

                        System.out.println("Enter customer email:");
                        String customerEmail = scanner.nextLine();

                        System.out.println("Enter date of contract:");
                        String customerDate = scanner.nextLine();

                        LeaseContract leaseContract = new LeaseContract(
                                customerDate,
                                customerName,
                                customerEmail,
                                vehicleToLease
                        );

                        contractFileManager.saveContract(leaseContract);

                        vehiclesList2.remove(indexToRemove);
                        DealershipFileManager.rewriteVehicle(vehiclesList2);

                        System.out.println("Vehicle has been leased and contract saved.");
                    } else {
                        System.out.println("Vehicle not found.");
                    }
                    break;
                default:
                    System.out.println("Error 404");
            }
        }
    }
}
