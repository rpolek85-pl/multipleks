package cinema.presentation.action;

import cinema.presentation.print.PrintSeats;
import cinema.service.SeatsService;
import cinema.session.Session;

import java.util.Scanner;

public class ChooseSeatAction implements MenuAction {
    private Session session;
    private final Scanner scanner = new Scanner(System.in);
    private final SeatsService ss = new SeatsService();

    public ChooseSeatAction(Session session) {
        this.session=session;
    }

    @Override
    public String getName() {
        return "Wybierz miejsce";
    }

    @Override
    public void execute() {
        if(session.getChosenFilmScreeningId() == 0){
            System.out.println("Nie wybrałeś seansu filmowego");
            return;
        }

        new PrintSeats(session.getChosenFilmScreeningId(), session.getChosenCinemaId()).print();

        System.out.println("Wybierz miejsce:");
        String input = scanner.next();

        int choice;
        try{choice = Integer.parseInt(input);}
        catch(NumberFormatException e){
            System.out.println("Błędny wybór");
            return;
        }

        if(!ss.exist(choice, session.getChosenFilmScreeningId(), session.getChosenCinemaId())){
            System.out.println("Wybór miejsca spoza zakresu");
            return;
        }

        if(!ss.isFree(choice, session.getChosenFilmScreeningId(), session.getChosenCinemaId())){
            System.out.println("Wybrane miejsce nie jest wolne");
            return;
        }

        session.addChosenSeatId(choice);
    }
}
