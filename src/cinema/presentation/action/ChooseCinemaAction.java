package cinema.presentation.action;

import cinema.presentation.print.PrintCinemas;
import cinema.service.CinemasService;
import cinema.session.Session;

import java.util.HashSet;
import java.util.Scanner;

public class ChooseCinemaAction implements MenuAction {
    private Session session;
    private final Scanner scanner = new Scanner(System.in);

    public ChooseCinemaAction(Session session) {
        this.session=session;
    }

    @Override
    public String getName() {
        return "Wybierz kino";
    }

    @Override
    public void execute() {
        CinemasService cinemasService = new CinemasService();

        new PrintCinemas().print();

        System.out.println("Wybierz kino:");
        String input = scanner.next();

        int choice;
        try{choice = Integer.parseInt(input);}
        catch(NumberFormatException e){
            System.out.println("Błędny wybór");
            return;
        }

        if(!cinemasService.exist(choice)){
            System.out.println("Wybór kina spoza zakresu");
            return;
        }

        if(session.getChosenCinemaId() != choice){
            session.setChosenCinemaId(choice);
            session.setChosenFilmScreeningId(0);
            session.setChosenSeatsId(new HashSet<>());
        }
    }
}
