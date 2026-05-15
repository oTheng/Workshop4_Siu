public class SalesContract extends Contract{

    public SalesContract(String dateOfContract, String customerName, String customerEmail, double vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }

    @Override
    double getTotalPrice(Vehicle vehicle, boolean finance, double loan) {

        return 0;
    }

    @Override
    double getMonthlyPayment(Vehicle vehicle, double loan) {

        return 0;
    }
}
