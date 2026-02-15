package cinema.entity;

import java.util.List;

public class CinemaHall {
    private static int idCounter = 1;
    private final int id;

    private String name;
    private List<Seat> seats;

    public CinemaHall(String name) {
        this.id = idCounter++;
        this.name = name;
    }
    public CinemaHall(String name, List<Seat> seats) {
        this.id = idCounter++;
        this.name = name;
        this.seats = seats;
    }

    public int getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public List<Seat> getSeats() {return seats;}
    public void setSeats(List<Seat> seats) {this.seats = seats;}
}
