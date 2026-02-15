package cinema.service;

import cinema.entity.Cinema;
import cinema.entity.FilmScreening;

import java.time.LocalDateTime;
import java.util.List;

public class FilmScreeningsService {
    protected FilmScreening findById(int id, int cinemaId) {
        List<FilmScreening> filmScreenings = getFilmScreeningsForCinema(cinemaId);

        FilmScreening filmScreening = filmScreenings.stream()
                .filter(fs -> fs.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException( "FilmScreening with ID " + id + " not found" ));

        return filmScreening;
    }

    public String nameFindById(int id, int cinemaId) {
        return findById(id, cinemaId).toString();
    }

    public boolean exist(int id, int cinemaId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        List<FilmScreening> filmScreenings = getFilmScreeningsForCinema(cinemaId);

        return filmScreenings.stream()
                .filter(fs -> !fs.getStartDateTime().isBefore(startDateTime))
                .filter(fs -> !fs.getStartDateTime().isAfter(endDateTime))
                .anyMatch(fs -> fs.getId() == id);
    }

    public List<String> getNames(int cinemaId, LocalDateTime startDateTime, LocalDateTime endDateTime) {
        List<FilmScreening> filmScreenings = getFilmScreeningsForCinema(cinemaId);

        List<String> filmScreeningNames = filmScreenings.stream()
                .filter(fs -> !fs.getStartDateTime().isBefore(startDateTime))
                .filter(fs -> !fs.getStartDateTime().isAfter(endDateTime))
                .map(FilmScreening::toString)
                .toList();

        return filmScreeningNames;
    }


    private List<FilmScreening> getFilmScreeningsForCinema(int cinemaId) {
        CinemasService cs = new CinemasService();
        Cinema cinema = cs.findById(cinemaId);

        return cinema.getFilmScreenings();
    }
}
