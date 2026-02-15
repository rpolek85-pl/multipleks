package cinema.presentation.provider;

import cinema.entity.CinemaWorld;
import cinema.presentation.action.MenuAction;
import cinema.session.Session;

import java.util.List;

public interface MenuProvider {
    List<MenuAction> getMenuActions(Session session, Runnable exitHandler);
}
