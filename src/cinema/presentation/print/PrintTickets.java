package cinema.presentation.print;

import cinema.service.PurchaseService;

import java.util.List;

public class PrintTickets implements PrintInterface {
    private int userId;

    public PrintTickets(int userId) {
        this.userId = userId;
    }

    @Override
    public void print() {
        PurchaseService ps = new PurchaseService();
        List<String> ticketNames = ps.getNames(userId);

        System.out.println("Twoje bilety:");
        for (String ticketName : ticketNames) {
            System.out.println("  " + ticketName);
        }
    }
}
