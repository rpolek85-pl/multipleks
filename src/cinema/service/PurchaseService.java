package cinema.service;

import cinema.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PurchaseService {
    private CustomersService customersService = new CustomersService();
    private FilmScreeningsService filmScreeningsService = new FilmScreeningsService();
    private SeatsService seatsService = new SeatsService();

    protected Ticket findById(int id) {
        CinemaWorld cw = CinemaWorld.getInstance();
        List<Ticket> tickets = cw.getTickets();

        return tickets.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Ticket with ID " + id + " not found"));
    }

    public String nameFindById(int id) {
        return findById(id).toString();
    }

    public List<String> getNames(int customerId) {
        CinemaWorld cw = CinemaWorld.getInstance();
        List<Ticket> tickets = cw.getTickets();

        return tickets.stream()
                .filter(t -> t.getCustomer().getId() == customerId)
                .map(Ticket::toString)
                .toList();
    }


    public boolean exist(int id) {
        return CinemaWorld.getInstance().getTickets().stream()
                .anyMatch(t -> t.getId() == id);
    }

    public void purchase(Set<Integer> seatsId, int filmScreeningId, int cinemaId, int customerId) {
        CinemaWorld cw = CinemaWorld.getInstance();
        Customer customer = customersService.findById(customerId);
        FilmScreening filmScreening = filmScreeningsService.findById(filmScreeningId, cinemaId);

        for(Integer seatId : seatsId ) {
            Seat seat = seatsService.findById(seatId, filmScreeningId, cinemaId);
            seat.setType(SeatType.PAID);
            cw.addTickets(new Ticket(filmScreening, seat, customer));
        }


    }
}
