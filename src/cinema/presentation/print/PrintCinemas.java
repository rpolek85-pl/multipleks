package cinema.presentation.print;
import cinema.entity.Cinema;
import cinema.entity.CinemaWorld;
import java.util.List;

public class PrintCinemas implements PrintInterface {

    @Override
    public void print() {
        CinemaWorld cw = CinemaWorld.getInstance();
        List<Cinema> cinemas = cw.getCinemas();

        System.out.println("Lista kin:");
        for (Cinema cinema : cinemas) {
            System.out.println(cinema.toString());
        }

    }
}