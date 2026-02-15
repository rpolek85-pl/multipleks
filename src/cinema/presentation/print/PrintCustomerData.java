package cinema.presentation.print;
import cinema.service.CustomersService;

public class PrintCustomerData implements PrintInterface {
    private final int customerId;

    public PrintCustomerData(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public void print() {
        CustomersService customersService = new CustomersService();

        if(customersService.exist(customerId)) {
            System.out.println(customersService.getName(customerId));
        }
    }
}
