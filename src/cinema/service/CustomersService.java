package cinema.service;

import cinema.entity.CinemaWorld;
import cinema.entity.Customer;
import cinema.entity.GuestCustomer;
import cinema.entity.RegisteredCustomer;

import java.util.List;

public class CustomersService {
    protected Customer findById(int id) {
        CinemaWorld cw = CinemaWorld.getInstance();
        List<Customer> customers = cw.getCustomers();

        Customer customer = customers.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Customer with ID " + id + " not found"));

        return customer;
    }

    public String getName(int id) {
        Customer customer = findById(id);
        return  customer.toString();
    }

    public String getEmail(int id) {
        Customer customer = findById(id);
        return customer.getEmail();
    }

    public boolean isRegisteredCustomer(int id) {
        CinemaWorld cw = CinemaWorld.getInstance();

        return cw.getCustomers().stream()
                .anyMatch(c -> c.getId() == id && c instanceof RegisteredCustomer);
    }

    public boolean exist(int id) {
        CinemaWorld cw = CinemaWorld.getInstance();

        return cw.getCustomers().stream()
                .anyMatch(c -> c.getId() == id);
    }

    public int createGuestCustomer(String email){
        CinemaWorld cw = CinemaWorld.getInstance();
        GuestCustomer guestCustomer = new GuestCustomer(email);
        cw.addCustomer(guestCustomer);
        return guestCustomer.getId();
    }

}
