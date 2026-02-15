package cinema.presentation.print;

import cinema.service.CinemasService;
import cinema.service.FilmScreeningsService;

import java.time.LocalDateTime;

public class PrintChoosenFilmScreening implements PrintInterface {
    private final int filmScreeningId;
    private final int cinemaId;

    public PrintChoosenFilmScreening(int filmScreeningId, int cinemaId) {
        this.cinemaId = cinemaId;
        this.filmScreeningId = filmScreeningId;
    }

    @Override
    public void print() {
        FilmScreeningsService filmScreeningsService = new FilmScreeningsService();
        CinemasService cinemasService = new CinemasService();

        if(cinemasService.exist(cinemaId) && filmScreeningsService.exist(filmScreeningId, cinemaId,  LocalDateTime.now(), LocalDateTime.now().plusDays(30))) {
            System.out.println(filmScreeningsService.nameFindById(filmScreeningId, cinemaId));
        }
    }
}
