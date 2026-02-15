package cinema.presentation.print;

import cinema.service.SeatsService;
import java.util.List;

public class PrintSeats implements PrintInterface{
    private int cinemaId;
    private int filmScreeningId;

    public PrintSeats(int filmScreeningId, int cinemaId) {
        this.cinemaId = cinemaId;
        this.filmScreeningId = filmScreeningId;
    }

    @Override
    public void print() {
        SeatsService ss = new SeatsService();
        List<String> seatNames = ss.getNames(filmScreeningId, cinemaId);

        System.out.println("Lista miejsc:");
        for (String seatName : seatNames) {
            System.out.println("  " + seatName);
        }
    }
}
