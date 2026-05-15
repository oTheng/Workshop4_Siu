import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeaseContractTest {
    @Test
    public void check() {
        LeaseContract leaseContract = new LeaseContract("Jan 1 2001", "John", "Jonha@yahoo.com", 20000);

        Vehicle vehicle = new Vehicle(2013, 2001, "Honda", "Honda", "SUV", "Red", 231445, 15022);

        double price = leaseContract.getMonthlyPayment(vehicle, 0);

        assertEquals(252.81, price, 1);
    }
}