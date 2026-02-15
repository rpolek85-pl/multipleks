package cinema.service;

import cinema.entity.Cinema;
import cinema.entity.CinemaWorld;
import java.util.List;

public class CinemasService {
    protected Cinema findById(int id) {
        CinemaWorld cw = CinemaWorld.getInstance();
        List<Cinema> cinemas = cw.getCinemas();

        Cinema cinema = cinemas.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Cinema with ID " + id + " not found"));

        return cinema;
    }

    public String nameFindById(int id) {
        return findById(id).toString();
    }

    public boolean exist(int id) {
        return CinemaWorld.getInstance().getCinemas().stream()
                .anyMatch(c -> c.getId() == id);
    }
}
