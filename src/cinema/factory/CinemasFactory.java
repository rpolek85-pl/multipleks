package cinema.factory;

import cinema.entity.Cinema;

import java.util.ArrayList;
import java.util.List;

public class CinemasFactory {
    public static List<Cinema> createExampleCinemas(){
        List<Cinema> cinemas = new ArrayList<>();

        Cinema cinema1 = new Cinema("Cinema World Kraków","Kraków", CinemaHallsFactory.createRandomCinemaHalls());
        cinema1.setFilmScreenings(FilmScreeningsFactory.createRandomFilmScreenings(cinema1.getCinemaHalls()));
        cinemas.add(cinema1);

        Cinema cinema2 = new Cinema("Cinema World Warszawa","Warszawa", CinemaHallsFactory.createRandomCinemaHalls());
        cinema2.setFilmScreenings(FilmScreeningsFactory.createRandomFilmScreenings(cinema2.getCinemaHalls()));
        cinemas.add(cinema2);

        Cinema cinema3 = new Cinema("Cinema World Gdańsk","Gdańsk", CinemaHallsFactory.createRandomCinemaHalls());
        cinema3.setFilmScreenings(FilmScreeningsFactory.createRandomFilmScreenings(cinema3.getCinemaHalls()));
        cinemas.add(cinema3);

        return cinemas;
    }
}
