package cinema.factory;

import cinema.entity.CinemaHall;
import cinema.entity.Seat;

import java.util.ArrayList;
import java.util.List;

public class CinemaHallsFactory {
    public static List<CinemaHall> createRandomCinemaHalls() {
        List<CinemaHall> cinemaHalls = new ArrayList<>();

        int randomNumberCinemaHalls = (int) (Math.random() * 10) + 2;

        for (int i = 1; i < randomNumberCinemaHalls; i++) {
            CinemaHall ch = new CinemaHall("Sala " + i);
            List<Seat> seats = SeatsFactory.createRandomSeats();
            ch.setSeats(seats);
            cinemaHalls.add(ch);
        }

        return cinemaHalls;
    }
}
