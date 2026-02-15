package cinema.presentation.action;

import cinema.presentation.print.PrintTickets;
import cinema.session.Session;

import java.util.Scanner;

public class ShowTicketsAction implements MenuAction {
    private Session session;

    public ShowTicketsAction(Session session) {
        this.session=session;
    }

    @Override
    public String getName() {
        return "Twoje bilety";
    }

    @Override
    public void execute() {
        new PrintTickets(session.getCustomerId()).print();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Naciśnij ENTER...");
        scanner.nextLine();
    }
}
