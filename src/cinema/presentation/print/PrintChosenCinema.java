package cinema.presentation.print;
import cinema.service.CinemasService;


public class PrintChosenCinema implements PrintInterface {
    private final int cinemaId;

    public PrintChosenCinema(int cinemaId) {
        this.cinemaId = cinemaId;
    }

    @Override
    public void print() {
        CinemasService cinemasService = new CinemasService();

        if(cinemasService.exist(cinemaId)) {
            System.out.println(cinemasService.nameFindById(cinemaId));
        }
    }
}
