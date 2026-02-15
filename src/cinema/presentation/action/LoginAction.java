package cinema.presentation.action;

import cinema.presentation.print.PrintRegisteredCustomers;
import cinema.service.CustomersService;
import cinema.session.Session;
import java.util.Scanner;

public class LoginAction implements MenuAction {
    private final Session session;
    private final Scanner scanner = new Scanner(System.in);

    public LoginAction(Session session) {
        this.session = session;
    }

    @Override
    public String getName(){
        return "Zaloguj";
    }

    @Override
    public void execute() {
        CustomersService customersService = new CustomersService();

        new PrintRegisteredCustomers().print();

        System.out.println("Wybierz klienta:");
        String input = scanner.next();

        int choice;
        try{choice = Integer.parseInt(input);}
        catch(NumberFormatException e){
            System.out.println("Błędny wybór");
            return;
        }

        if(!customersService.isRegisteredCustomer(choice)){
            System.out.println("Wybór klienta spoza zakresu");
            return;
        }

        session.login(choice, customersService.getEmail(choice));
    }
}
