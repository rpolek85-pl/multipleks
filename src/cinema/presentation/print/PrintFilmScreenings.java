package cinema.presentation.print;

import cinema.entity.FilmScreening;
import cinema.service.FilmScreeningsService;

import java.time.LocalDateTime;
import java.util.List;

public class PrintFilmScreenings implements PrintInterface {
    private int cinemaId;
    private LocalDateTime endDate;

    public PrintFilmScreenings(int cinemaId, LocalDateTime endDate) {
        this.cinemaId = cinemaId;
        this.endDate  = endDate;
    }

    @Override
    public void print() {
        FilmScreeningsService filmScreeningsService = new FilmScreeningsService();
        List<String> filmScreeningNames = filmScreeningsService.getNames(cinemaId, LocalDateTime.now(), endDate);

        System.out.println("Lista seansów filmowych:");
        for (String filmScreeningName : filmScreeningNames) {
            System.out.println("  " + filmScreeningName);
        }
    }
}
