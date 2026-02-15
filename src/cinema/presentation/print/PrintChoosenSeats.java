package cinema.presentation.print;

import cinema.service.CinemasService;
import cinema.service.FilmScreeningsService;
import cinema.service.SeatsService;

import java.time.LocalDateTime;
import java.util.Set;

public class PrintChoosenSeats implements PrintInterface {
    private final int filmScreeningId;
    private final int cinemaId;
    private final Set<Integer> chosenSeatsId;

    public PrintChoosenSeats(Set<Integer> chosenSeatsId, int filmScreeningId, int cinemaId) {
        this.cinemaId = cinemaId;
        this.filmScreeningId = filmScreeningId;
        this.chosenSeatsId = chosenSeatsId;
    }

    @Override
    public void print() {
        SeatsService ss = new SeatsService();
        FilmScreeningsService fs = new FilmScreeningsService();
        CinemasService cs = new CinemasService();

        if(cs.exist(cinemaId) && fs.exist(filmScreeningId, cinemaId, LocalDateTime.now(), LocalDateTime.now().plusDays(30))) {
            for(Integer seatId : chosenSeatsId) {
                if(ss.exist(seatId,filmScreeningId,cinemaId)) {
                    System.out.println(ss.nameFindById(seatId, filmScreeningId, cinemaId));
                }
            }

        }
    }
}
