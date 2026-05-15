public class LeaseContract extends Contract {

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, double vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }

    @Override
    double getTotalPrice(Vehicle vehicle, boolean finance, double loan) {
        double expectedValue = vehicle.getPrice() * 0.50;
        double leaseFee = vehicle.getPrice() * 0.07;

        return vehicle.getPrice() - expectedValue + leaseFee;
    }

    @Override
    double getMonthlyPayment(Vehicle vehicle, double loan) {
        double leaseTotalPrice = getTotalPrice(vehicle, true, loan);

        double annualInterestRate = 0.04;
        int months = 36;

        double monthlyRate = annualInterestRate / 12;

        return leaseTotalPrice * (monthlyRate * Math.pow(1 + monthlyRate, months)) / (Math.pow(1 + monthlyRate, months) - 1);
    }
}