package cinema.entity;

import java.time.LocalDateTime;

public class Ticket {
    private static int idCounter = 1;
    private final int id;

    private final FilmScreening filmScreening;
    private final Seat seat;
    private final Customer customer;
    private final LocalDateTime purchaseTime;
    private TicketStatus ticketStatus;

    public Ticket(FilmScreening filmScreening, Seat seat, Customer customer) {
        this.id = idCounter++;
        this.filmScreening = filmScreening;
        this.seat = seat;
        this.customer = customer;
        this.purchaseTime = LocalDateTime.now();
        this.ticketStatus = TicketStatus.ACTIVE;
    }

    public int getId() {return id;}

    public FilmScreening getFilmScreening() {return filmScreening;}
    public Seat getSeat() {return seat;}
    public Customer getCustomer() {return customer;}
    public LocalDateTime getPurchaseTime() {return purchaseTime;}
    public TicketStatus getTicketStatus() {return ticketStatus;}

    public void setTicketStatus(TicketStatus ticketStatus) {this.ticketStatus = ticketStatus;}

    public String toString(){
        return "Ticket #id=" + id + " " + filmScreening + " " + seat.toString();
    }
}
