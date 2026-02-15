package cinema.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class FilmScreening {
    private static int idCounter = 1;
    private final int id;

    private final Movie movie;
    private final CinemaHall cinemaHall;
    private final LocalDateTime startDateTime;
    private final FilmScreeningType filmScreeningType;
    private Map<Seat, SeatStatus> seatStatusMap;

    public FilmScreening(Movie movie, CinemaHall cinemaHall, LocalDateTime startDateTime, FilmScreeningType filmScreeningType) {
        this.id = idCounter++;
        this.movie = movie;
        this.cinemaHall = cinemaHall;
        this.startDateTime = startDateTime;
        this.filmScreeningType = filmScreeningType;
    }

    public int getId() {return id;}

    public Movie getMovie() {return this.movie;}
    public CinemaHall getCinemaHall() {return cinemaHall;}
    public LocalDateTime getStartDateTime() {return startDateTime;}
    public FilmScreeningType getFilmScreeningType() {return filmScreeningType;}
    public Map<Seat, SeatStatus> getSeatStatusMap() {return seatStatusMap;}

    public String toString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "FilmScreening #" + id + " " + movie.getTitle() + " " + filmScreeningType + " " + cinemaHall.getName() + " " + startDateTime.format(formatter);
    }


}
