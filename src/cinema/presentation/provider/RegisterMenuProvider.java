package cinema.presentation.provider;

import cinema.presentation.action.*;
import cinema.session.Session;

import java.util.List;

public class RegisterMenuProvider implements MenuProvider {
    @Override
    public List<MenuAction> getMenuActions(Session session, Runnable exitHandler) {
        return List.of(
                new LogoutAction(session),
                new ChooseCinemaAction(session),
                new ChooseFilmScreeningAction(session),
                new ChooseSeatAction(session),
                new BookingForRegisteredCustomerAction(session),
                new ShowReservationsAction(session),
                new PurchaseAction(session),
                new ShowTicketsAction(session),
                new ScreeningsForNext7DaysAction(session),
                new ExitAction(exitHandler)
        );
    }
}
