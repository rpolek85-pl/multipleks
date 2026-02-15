package cinema.presentation.print;

import cinema.entity.CinemaWorld;
import cinema.entity.Customer;
import cinema.entity.RegisteredCustomer;
import java.util.List;

public class PrintRegisteredCustomers implements PrintInterface{

    public PrintRegisteredCustomers(){
    }

    @Override
    public  void print() {
        CinemaWorld cw = CinemaWorld.getInstance();
        List<Customer> customers = cw.getCustomers();

        System.out.println("Lista zarejestrowanych klientów:");

        for (Customer customer : customers) {
            if (customer instanceof RegisteredCustomer) {
                System.out.println(customer.toString()); }
        }

    }
}
