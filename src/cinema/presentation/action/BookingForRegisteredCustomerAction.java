package cinema.presentation.action;

import cinema.service.BookingService;
import cinema.session.Session;

import java.util.HashSet;


public class BookingForRegisteredCustomerAction implements MenuAction {
    private Session session;
    public BookingForRegisteredCustomerAction(Session session) {
        this.session=session;
    }

    @Override
    public String getName() {
        return "Rezerwuj wybrane miejsca";
    }

    @Override
    public void execute() {
        BookingService bs = new BookingService();

        if(session.getChosenSeatsId().isEmpty()){
            System.out.println("Wybierz miejsca do rezerwacji");
            return;
        }

        bs.bookingForRegisteredCustomer(session.getChosenSeatsId(),session.getChosenFilmScreeningId(),session.getChosenCinemaId(),session.getCustomerId());
        session.setChosenSeatsId(new HashSet<>());

        System.out.println("Rezerwacja zakończona sukcesem");

    }
}
