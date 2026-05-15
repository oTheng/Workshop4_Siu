import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class LeaseContractTest {
    @Test
    public void check() {
        LeaseContract leaseContract = new LeaseContract("Jan 1 2001","John","Jonha@yahoo.com", 20000);
        var price = leaseContract.getTotalPrice(new Vehicle(2013, 2001, "Honda", "Honda", "SUV", "Red",231445, 15022), true, 16600);
        assertEquals(376, price, 1);
    }


}