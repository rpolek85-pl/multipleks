package cinema.presentation.print;

import cinema.service.BookingService;

import java.util.List;

public class PrintBooking implements PrintInterface {
    private int userId;

    public PrintBooking(int userId) {
        this.userId = userId;
    }

    @Override
    public void print() {
        BookingService bs = new BookingService();
        List<String> bookingNames = bs.getNames(userId);

        System.out.println("Twoje rezerwacje:");
        for (String bookingName : bookingNames) {
            System.out.println("  " + bookingName);
        }
    }
}
