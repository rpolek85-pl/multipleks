package cinema.service;

import cinema.entity.CinemaHall;
import cinema.entity.Seat;

import java.util.List;

public class SeatsService {
    private final FilmScreeningsService fss = new FilmScreeningsService();

    protected Seat findById(int id, int filmScreeningId, int cinemaId) {
        List<Seat> seats = getCinemaHallForCinemaForFilmScreening(filmScreeningId, cinemaId).getSeats();

        Seat seat = seats.stream()
                .filter(fs -> fs.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException( "Seat with ID " + id + " not found" ));

        return seat;
    }

    public String nameFindById(int id, int filmScreeningId, int cinemaId) {
        return findById(id, filmScreeningId, cinemaId).toString();
    }

    public boolean exist(int id, int filmScreeningId, int cinemaId) {
        List<Seat> seats = getCinemaHallForCinemaForFilmScreening(filmScreeningId, cinemaId).getSeats();

        return seats.stream()
                .anyMatch(fs -> fs.getId() == id);
    }

    public boolean isFree(int id, int filmScreeningId, int cinemaId) {
        List<Seat> seats = getCinemaHallForCinemaForFilmScreening(filmScreeningId, cinemaId).getSeats();

        Seat seat = seats.stream()
                .filter(fs -> fs.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException( "Seat with ID " + id + " not found" ));

        return seat.isFree();
    }

    public List<String> getNames(int filmScreeningId, int cinemaId) {
        List<Seat> seats = getCinemaHallForCinemaForFilmScreening(filmScreeningId, cinemaId).getSeats();

        return seats.stream()
                .map(Seat::toString)
                .toList();
    }

    private CinemaHall getCinemaHallForCinemaForFilmScreening(int filmScreeningId, int cinemaId) {
        return fss.findById(filmScreeningId, cinemaId).getCinemaHall();
    }
}
