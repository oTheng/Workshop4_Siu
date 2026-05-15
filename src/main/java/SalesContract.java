import java.util.Scanner;

public class SalesContract extends Contract {
    private boolean finance;
    private double loanAmount;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, boolean finance, double loanAmount) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.finance = finance;
        this.loanAmount = loanAmount;
    }

    @Override
    double getTotalPrice(Vehicle vehicle, boolean finance, double loan) {
        return vehicle.getPrice()
                + getSalesTax()
                + getRecordingFee()
                + getProcessingFee();
    }

    @Override
    double getMonthlyPayment(Vehicle vehicle, double loan) {
        if (!finance) {
            return 0;
        }

        double totalPrice = getTotalPrice(vehicle, finance, loan);

        if (loan < totalPrice) {
            System.out.println("You need to take out a bigger loan!");
            return 0;
        }

        double annualInterestRate;
        int months;

        if (loan >= 10000) {
            annualInterestRate = 0.0425;
            months = 48;
        } else {
            annualInterestRate = 0.0525;
            months = 24;
        }

        double monthlyRate = annualInterestRate / 12;

        return loan *
                (monthlyRate * Math.pow(1 + monthlyRate, months)) /
                (Math.pow(1 + monthlyRate, months) - 1);
    }

    public double getSalesTax() {
        return vehicleSold.getPrice() * 0.05;
    }

    public double getRecordingFee() {
        return 100;
    }

    public double getProcessingFee() {
        if (vehicleSold.getPrice() < 10000) {
            return 295;
        }
        return 495;
    }

    @Override
    public String toFileString() {
        double monthlyPayment = finance ? getMonthlyPayment(vehicleSold, loanAmount) : 0;

        return String.format(
                "SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%.2f|%s|%.2f",
                dateOfContract,
                customerName,
                customerEmail,
                vehicleSold.getVin(),
                vehicleSold.getYear(),
                vehicleSold.getMake(),
                vehicleSold.getModel(),
                vehicleSold.getVehicleType(),
                vehicleSold.getColor(),
                vehicleSold.getOdometer(),
                vehicleSold.getPrice(),
                getSalesTax(),
                getRecordingFee(),
                getProcessingFee(),
                getTotalPrice(vehicleSold, finance, loanAmount),
                finance ? "YES" : "NO",
                monthlyPayment
        );
    }
}