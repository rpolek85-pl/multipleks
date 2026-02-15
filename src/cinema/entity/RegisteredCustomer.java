package cinema.entity;

import java.util.List;

public class RegisteredCustomer extends Customer {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String address;
    private List<Ticket> tickets;

    public RegisteredCustomer(String firstName, String lastName, String phoneNumber, String address, String email) {
        super(email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public List<Ticket> getTickets() {return tickets;}
    public void addTicket(Ticket ticket) {tickets.add(ticket);}

    public String toString(){
        return "Customer #" + getId() + " " + firstName + " " + lastName + ", " + phoneNumber + ", " + address + ", " + getEmail();
    }
}
