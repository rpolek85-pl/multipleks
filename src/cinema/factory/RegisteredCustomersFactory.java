package cinema.factory;

import cinema.entity.RegisteredCustomer;

import java.util.ArrayList;
import java.util.List;

public class RegisteredCustomersFactory {
    public static List<RegisteredCustomer> getExampleRegisteredCustomers() {
        List<RegisteredCustomer> registeredCustomers = new ArrayList<>();

        RegisteredCustomer rc1 = new RegisteredCustomer("Rafał", "Nowak", "+48678678672","Kraków","rafal.nowak@gmail.com");
        RegisteredCustomer rc2 = new RegisteredCustomer("Paweł", "Kowal", "+48678678673","Warszawa","pawel.kowal@gmail.com");
        RegisteredCustomer rc3 = new RegisteredCustomer("Piotr", "Las", "+48678678658","Gdańsk","piotr.las@gmail.com");

        registeredCustomers.add(rc1);
        registeredCustomers.add(rc2);
        registeredCustomers.add(rc3);

        return  registeredCustomers;
    }
}
