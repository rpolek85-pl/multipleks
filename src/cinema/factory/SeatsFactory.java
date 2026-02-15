package cinema.factory;

import cinema.entity.RowLabel;
import cinema.entity.Seat;

import java.util.ArrayList;
import java.util.List;

public class SeatsFactory {
    public static List<Seat> createRandomSeats(){
        List<Seat> seats = new ArrayList<>();

        int randomNumberRow = (int) (Math.random() * 22) + 2;
        int randomNumberNumber = (int) (Math.random() * 30) + 2;

        for(int i = 1; i < randomNumberRow; i++){
            for(int j = 1; j < randomNumberNumber; j++){
                Seat s = new Seat(RowLabel.values()[i],j);
                seats.add(s);
            }
        }

        return  seats;
    }
}
