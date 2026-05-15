public abstract class Contract {
    private String dateOfContract;
    private String customerName;
    private String customerEmail;
    private double vehicleSold;

    public Contract(String dateOfContract, String customerName, String customerEmail, double vehicleSold) {
        this.dateOfContract = dateOfContract;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    public String getDateOfContract() {
        return dateOfContract;
    }

    public void setDateOfContract(String dateOfContract) {
        this.dateOfContract = dateOfContract;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public double getVehicleSold() {
        return vehicleSold;
    }

    public void setVehicleSold(double vehicleSold) {
        this.vehicleSold = vehicleSold;
    }
    abstract double getTotalPrice(Vehicle vehicle, boolean finance, double loan);

    abstract double getMonthlyPayment(Vehicle vehicle, double loan);
}
