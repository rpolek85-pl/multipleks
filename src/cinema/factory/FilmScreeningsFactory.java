package cinema.factory;

import cinema.entity.CinemaHall;
import cinema.entity.FilmScreening;
import cinema.entity.FilmScreeningType;

import java.util.ArrayList;
import java.util.List;

public class FilmScreeningsFactory {

    public static List<FilmScreening> createRandomFilmScreenings(List<CinemaHall> cinemaHalls) {
        List<FilmScreening> filmScreenings = new ArrayList<>();

        for (CinemaHall cinemaHall : cinemaHalls) {
            int randomNumberFilmScreenings = (int) (Math.random() * 5) + 2;

            for (int i = 0; i < randomNumberFilmScreenings; i++) {
                int randomFilmScreeningType = (int) (Math.random() * 3);
                FilmScreening fs = new FilmScreening(
                        MovieFactory.createRandomMovie(),
                        cinemaHall,
                        RandomDateFactory.randomDate(),
                        FilmScreeningType.values()[randomFilmScreeningType]
                );
                filmScreenings.add(fs);
            }
        }

        return filmScreenings;
    }
}

