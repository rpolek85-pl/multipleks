package cinema.presentation.action;

import cinema.presentation.print.PrintFilmScreenings;
import cinema.service.FilmScreeningsService;
import cinema.session.Session;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Scanner;

public class ChooseFilmScreeningAction implements MenuAction {
    private Session session;
    private final Scanner scanner = new Scanner(System.in);
    private final FilmScreeningsService filmScreeningsService = new FilmScreeningsService();

    public ChooseFilmScreeningAction(Session session) {
        this.session=session;
    }

    @Override
    public String getName() {
        return "Wybierz seans filmowy";
    }

    @Override
    public void execute() {
        if(session.getChosenCinemaId() == 0){
            System.out.println("Nie wybrałeś kina");
            return;
        }

        new PrintFilmScreenings(session.getChosenCinemaId(), LocalDateTime.now().plusDays(30)).print();

        System.out.println("Wybierz seans filmowy:");
        String input = scanner.next();

        int choice;
        try{choice = Integer.parseInt(input);}
        catch(NumberFormatException e){
            System.out.println("Błędny wybór");
            return;
        }

        if(!filmScreeningsService.exist(choice, session.getChosenCinemaId(), LocalDateTime.now(), LocalDateTime.now().plusDays(30))){
            System.out.println("Wybór seansu filmowego spoza zakresu");
            return;
        }

        if(session.getChosenFilmScreeningId() != choice){
            session.setChosenFilmScreeningId(choice);
            session.setChosenSeatsId(new HashSet<>());
        }

    }
}
