package cinema.presentation.action;

import cinema.presentation.print.PrintFilmScreenings;
import cinema.session.Session;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ScreeningsForNext7DaysAction implements MenuAction{
    private Session session;
    private final Scanner scanner = new Scanner(System.in);

    public ScreeningsForNext7DaysAction(Session session) {
        this.session=session;
    }

    @Override
    public String getName() {
        return "Pokaż repertuar na tydzień";
    }

    @Override
    public void execute() {
        if(session.getChosenCinemaId() == 0){
            System.out.println("Nie wybrałeś kina");
            return;
        }
        new PrintFilmScreenings(session.getChosenCinemaId(), LocalDateTime.now().plusDays(7)).print();

        System.out.println("Naciśnij ENTER...");
        scanner.nextLine();
    }
}
