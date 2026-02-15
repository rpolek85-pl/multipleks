package cinema.presentation.provider;

import cinema.presentation.action.*;
import cinema.session.Session;

import java.util.List;

public class GuestMenuProvider implements MenuProvider {
    @Override
    public List<MenuAction> getMenuActions(Session session, Runnable exitHandler) {
        return List.of(
                new LoginAction(session),
                new ChooseCinemaAction(session),
                new ChooseFilmScreeningAction(session),
                new ChooseSeatAction(session),
                new PurchaseAction(session),
                new ShowTicketsAction(session),
                new ScreeningsForNext7DaysAction( session),
                new ExitAction(exitHandler)
        );
    }
}
