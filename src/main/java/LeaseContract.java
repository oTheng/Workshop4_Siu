public class LeaseContract extends Contract {

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, double vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }

    @Override
    double getTotalPrice(Vehicle vehicle, boolean finance, double loan) {
        double saleTax = vehicle.getPrice() * 0.05;
        double recordingFee = 100;
        double processingFee;
        double finalprice = 0;
        if (vehicle.getPrice() <= 10000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }
        if (finance) {
            finalprice = getMonthlyPayment(vehicle, loan);
        } else {
            finalprice = vehicle.getPrice() + saleTax + recordingFee + processingFee;
        }
        return finalprice;
    }

    @Override
    double getMonthlyPayment(Vehicle vehicle, double loan) {
        double monthlyCalculation = 0;
        if (loan < vehicle.getPrice()) {
            System.out.println("You need to take out a bigger loan!");
        } else {
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

            monthlyCalculation = loan * (monthlyRate * Math.pow(1 + monthlyRate, months)) / (Math.pow(1 + monthlyRate, months) - 1);
        }

        return monthlyCalculation;
    }
}
