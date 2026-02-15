package cinema.presentation;

import cinema.factory.CinemaWorldFactory;
import cinema.presentation.action.MenuAction;
import cinema.presentation.print.*;
import cinema.presentation.provider.GuestMenuProvider;
import cinema.presentation.provider.MenuProvider;
import cinema.presentation.provider.RegisterMenuProvider;
import cinema.entity.CinemaWorld;
import cinema.service.CustomersService;
import cinema.service.LogoService;
import cinema.session.Session;

import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Session session;
    private final Scanner scanner = new Scanner(System.in);
    private boolean running = true;
    private final LogoService logoService = new LogoService();

    public Menu(Session session) {
        this.session = session;
    }

    public void start() {
        while (running) {
            MenuProvider menuProvider = selectMenuProvider();
            List<MenuAction> menuActions = menuProvider.getMenuActions(session, this::stop);

            logoService.printLogoCinemaWorld();
            new PrintCustomerData(session.getCustomerId()).print();
            new PrintChosenCinema(session.getChosenCinemaId()).print();
            new PrintChoosenFilmScreening(session.getChosenFilmScreeningId(), session.getChosenCinemaId()).print();
            new PrintChoosenSeats(session.getChosenSeatsId(),session.getChosenFilmScreeningId(), session.getChosenCinemaId()).print();

            printMenu(menuActions);

            System.out.println("Wybierz opcje:");
            String input = scanner.next();

            int choice;
            try{choice = Integer.parseInt(input);}
            catch(NumberFormatException e){
                System.out.println("Błędny wybór opcji");
                continue;
            }

            if(choice < 1 || choice > menuActions.size()){
                System.out.println("Wybór opcji spoza zakresu");
                continue;
            }

            menuActions.get(choice - 1).execute();
        }

    }

    private void stop(){
        running = false;
    }

    private MenuProvider selectMenuProvider() {
        CustomersService customersService = new CustomersService();
        return customersService.isRegisteredCustomer(session.getCustomerId())?new RegisterMenuProvider(): new GuestMenuProvider();
    }

    private void printMenu(List<MenuAction> menuActions) {
        System.out.println("Menu:");
        for (int i = 0; i < menuActions.size(); i++) {
            MenuAction menuAction = menuActions.get(i);
            System.out.println("  " + (i + 1) + ". " + menuAction.getName());
        }
    }
}
