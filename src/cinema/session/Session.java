package cinema.session;
import cinema.entity.Customer;
import cinema.entity.GuestCustomer;
import cinema.entity.RegisteredCustomer;

import java.util.HashSet;
import java.util.Set;

public class Session {
    private int customerId;
    private String email;
    private int chosenCinemaId;
    private int chosenFilmScreeningId;
    private Set<Integer> chosenSeatsId = new HashSet<>();

    public int getCustomerId() { return customerId; }
    public void setCustomerId(int customerId) { this.customerId = customerId; }

    public void login(int customerId, String email){
        this.customerId = customerId;
        this.email = email;
    }
    public void logout(){
        this.email = null;
        this.customerId = -1;
    }

    public int getChosenCinemaId() {return chosenCinemaId;}
    public void setChosenCinemaId(int chosenCinemaId) {this.chosenCinemaId = chosenCinemaId;}

    public int getChosenFilmScreeningId() {return chosenFilmScreeningId;}
    public void setChosenFilmScreeningId(int filmScreeningId){this.chosenFilmScreeningId = filmScreeningId;}

    public Set<Integer> getChosenSeatsId() {return chosenSeatsId;}
    public void setChosenSeatsId(Set<Integer> chosenSeatsId){this.chosenSeatsId = chosenSeatsId;}
    public void addChosenSeatId(int chosenSeatId){chosenSeatsId.add(chosenSeatId);}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}


}
