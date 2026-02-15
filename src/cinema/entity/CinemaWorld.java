package cinema.entity;

import java.util.ArrayList;
import java.util.List;

public class CinemaWorld {
    private static CinemaWorld instance;
    private String name;
    private String address;
    private final List<Cinema> cinemas;
    private List<Customer> customers;
    private List<Reservation> reservations;
    private List<Ticket> tickets;

    private CinemaWorld(String name, String address,  List<Cinema> cinemaList) {
        this.name = name;
        this.address = address;
        this.cinemas = new ArrayList<>();
        this.cinemas.addAll(cinemaList);
        this.reservations = new ArrayList<>();
        this.tickets = new ArrayList<>();
    }

    public static synchronized CinemaWorld init(String name, String address, List<Cinema> cinemaList){
        if (instance == null) {
            instance = new CinemaWorld(name, address, cinemaList);
        }
        return instance;
    }

    public static CinemaWorld getInstance() {
        if (instance == null) {
            throw new IllegalStateException("CinemaWorld not initialized.");
        }
        return instance;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public List<Cinema> getCinemas() {return cinemas;}
    public void addCinema(Cinema cinema){this.cinemas.add(cinema);}

    public List<Customer> getCustomers() {return customers;}

    public void addCustomer(Customer customer) {this.customers.add(customer);}

    public void setCustomers(List<Customer> customers) {this.customers = new ArrayList<>(customers);}

    public void setRegisteredCustomers(List<RegisteredCustomer> registeredCustomers) {
        this.customers = new ArrayList<>(registeredCustomers);
    }

    public List<Reservation> getReservations() {return reservations;}
    public void addReservation(Reservation reservation){this.reservations.add(reservation);}

    public List<Ticket> getTickets() {return tickets;}
    public void addTickets(Ticket ticket){this.tickets.add(ticket);}
}
