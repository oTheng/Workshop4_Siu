public class LeaseContract extends Contract {

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, double vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }

    @Override
    double getTotalPrice(Vehicle vehicle, boolean finance, double loan){

        return loan;
    }

    @Override
    double getMonthlyPayment(Vehicle vehicle, double loan) {

        return loan;
    }
}
