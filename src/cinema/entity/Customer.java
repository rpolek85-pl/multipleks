package cinema.entity;

public class Customer {
    private static int idCounter = 1;
    private final int id;

    private String email;

    public Customer() {this.id = idCounter++;}
    public Customer(String email) {
        this.id = idCounter++;
        this.email = email;
    }

    public int getId() {return id;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    @Override
    public String toString() { return "Customer #" + id + " " + email; }
}
