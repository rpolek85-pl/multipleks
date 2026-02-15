package cinema.presentation.action;

import cinema.presentation.print.PrintBooking;
import cinema.service.BookingService;
import cinema.session.Session;

import java.util.Scanner;

public class ShowReservationsAction implements MenuAction {
    private Session session;
    private final BookingService bs = new BookingService();
    private final Scanner scanner = new Scanner(System.in);

    public ShowReservationsAction(Session session) {this.session=session;}

    @Override
    public String getName() {
        return "Twoje rezerwacje";
    }

    @Override
    public void execute() {
        new PrintBooking(session.getCustomerId()).print();

        System.out.println("Wybierz rezerwacje:");
        String input = scanner.next();

        int choice;
        try{choice = Integer.parseInt(input);}
        catch(NumberFormatException e){
            System.out.println("Błędny wybór");
            return;
        }

        if(!bs.exist(choice)){
            System.out.println("Wybór rezerwacji spoza zakresu");
            return;
        }

        session.setChosenCinemaId(bs.getCinemaId(choice));
        session.setChosenFilmScreeningId(bs.getFilmScreeningId(choice));
        session.setChosenSeatsId(bs.getSeatsId(choice));


    }
}
