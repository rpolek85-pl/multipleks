package cinema.presentation.action;

import cinema.presentation.provider.GuestMenuProvider;
import cinema.presentation.provider.RegisterMenuProvider;
import cinema.service.CustomersService;
import cinema.service.PurchaseService;
import cinema.session.Session;

import java.util.HashSet;
import java.util.Scanner;

public class PurchaseAction implements MenuAction{
    private Session session;
    private final Scanner scanner = new Scanner(System.in);
    public PurchaseAction(Session session) {
        this.session=session;
    }

    @Override
    public String getName() {
        return "Kup bilety";
    }

    @Override
    public void execute() {
        CustomersService customersService = new CustomersService();
        PurchaseService ps = new PurchaseService();

        if(session.getChosenSeatsId().isEmpty()){
            System.out.println("Wybierz miejsca");
            return;
        }

        if (!customersService.isRegisteredCustomer(session.getCustomerId())){
            System.out.println("Podaj adres e-mail:");
            String input = scanner.next();
            session.setEmail(input);
            session.setCustomerId(customersService.createGuestCustomer(session.getEmail()));
        }


        ps.purchase(session.getChosenSeatsId(),session.getChosenFilmScreeningId(),session.getChosenCinemaId(),session.getCustomerId());
        session.setChosenSeatsId(new HashSet<>());

        System.out.println("Zakup zakończył sukcesem");

    }
}
