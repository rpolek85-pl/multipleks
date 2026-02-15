package cinema.entity;

import java.time.LocalDateTime;
import java.util.Set;

public class Reservation {
    private static int idCounter = 1;
    private final int id;
    private final int cinemaId;

    private final FilmScreening filmScreening;
    private final Set<Integer> seatsId;
    private final Customer customer;
    private final LocalDateTime creationTime;
    private final LocalDateTime expirationTime;
    private ReservationStatus status;


    public Reservation(FilmScreening filmScreening, Set<Integer> seatsId, Customer customer,int cinemaId,  LocalDateTime expirationTime) {
        this.id = idCounter++;
        this.filmScreening = filmScreening;
        this.seatsId = seatsId;
        this.customer = customer;
        this.creationTime = LocalDateTime.now();
        this.expirationTime = expirationTime;
        this.status = ReservationStatus.ACTIVE;
        this.cinemaId = cinemaId;
    }

    public int getId() {return id;}

    public FilmScreening getFilmScreening() {return filmScreening;}
    public Set<Integer>  getSeatsId() {return seatsId;}
    public Customer getCustomer() {return customer;}
    public LocalDateTime getCreationTime() {return creationTime;}
    public LocalDateTime getExpirationTime() {return expirationTime;}
    public ReservationStatus getStatus() {return status;}
    public int getCinemaId() {return cinemaId;}

    public void setStatus(ReservationStatus status) {this.status = status;}


    public String toString() {
        return "Reservation #" + id + " " + filmScreening + " "  + customer.getEmail();
    }
}
