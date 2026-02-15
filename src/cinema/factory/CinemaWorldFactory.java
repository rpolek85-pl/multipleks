package cinema.factory;

import cinema.entity.CinemaWorld;

public class CinemaWorldFactory {

    public static CinemaWorld createExampleCinemaWorld() {

        CinemaWorld.init("Cinema World", "Kraków", CinemasFactory.createExampleCinemas());

        CinemaWorld cw = CinemaWorld.getInstance();
        cw.setRegisteredCustomers(RegisteredCustomersFactory.getExampleRegisteredCustomers());
        return cw;
    }
}
