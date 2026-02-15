package cinema.presentation.action;

import cinema.session.Session;

public class LogoutAction implements MenuAction {
    private Session session;

    public LogoutAction(Session session) {
        this.session=session;
    }

    @Override
    public String getName() {
        return "Wyloguj";
    }

    @Override
    public void execute() {
        session.logout();
    }
}
