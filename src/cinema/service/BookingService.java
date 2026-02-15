package cinema.service;

import cinema.entity.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class BookingService {
    private CustomersService customersService = new CustomersService();
    private CinemasService cinemasService = new CinemasService();
    private FilmScreeningsService filmScreeningsService = new FilmScreeningsService();
    private SeatsService seatsService = new SeatsService();

    protected Reservation findById(int id) {
        CinemaWorld cw = CinemaWorld.getInstance();
        List<Reservation> reservations = cw.getReservations();

        return reservations.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Reservation with ID " + id + " not found"));
    }

    public String nameFindById(int id) {
        return findById(id).toString();
    }

    public List<String> getNames(int customerId) {
        CinemaWorld cw = CinemaWorld.getInstance();
        List<Reservation> reservations = cw.getReservations();

        return reservations.stream()
                .filter(r -> r.getCustomer().getId() == customerId)
                .map(Reservation::toString)
                .toList();
    }


    public boolean exist(int id) {
        return CinemaWorld.getInstance().getReservations().stream()
                .anyMatch(r -> r.getId() == id);
    }

    public void bookingForRegisteredCustomer(Set<Integer> seatsId, int filmScreeningId, int cinemaId, int customerId) {
        CinemaWorld cw = CinemaWorld.getInstance();

        Customer customer = customersService.findById(customerId);
        FilmScreening filmScreening = filmScreeningsService.findById(filmScreeningId, cinemaId);
        for(Integer seatId : seatsId ) {
            Seat seat = seatsService.findById(seatId, filmScreeningId, cinemaId);
            seat.setType(SeatType.RESERVED);
        }

        Reservation reservation = new Reservation(filmScreening,seatsId,customer, cinemaId, LocalDateTime.now().plusDays(30));
        cw.addReservation(reservation);
    }

    public Set<Integer> getSeatsId(int id) {
        return findById(id).getSeatsId();
    }

    public int getCinemaId(int id) {
        return findById(id).getCinemaId();
    }

    public int getFilmScreeningId(int id) {
        return findById(id).getFilmScreening().getId();
    }


}
