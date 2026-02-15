
import cinema.factory.CinemaWorldFactory;
import cinema.presentation.Menu;
import cinema.session.Session;

public class mian {
    public static void main(String[] args) {
        CinemaWorldFactory.createExampleCinemaWorld();

        Menu menu = new Menu(new Session());
        menu.start();
    }
}
