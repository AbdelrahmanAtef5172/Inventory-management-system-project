package customer;

public class CustomerProductTest {
    public static void main(String[] args) {
        CustomerProduct cp = new CustomerProduct("123-45-6789", "P0011", java.time.LocalDate.of(2025, 6, 12));
        cp.setPaid(true);

        System.out.println("Line Representation: " + cp.lineRepresentation());
        System.out.println("Search Key: " + cp.getSearchKey());
    }
}
