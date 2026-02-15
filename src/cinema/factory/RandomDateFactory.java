package cinema.factory;

import java.time.LocalDateTime;

public class RandomDateFactory {
    public static LocalDateTime randomDate() {
        return LocalDateTime.now()
                .plusDays((int) (Math.random() * 30) + 1)
                .plusHours((int) (Math.random() * 24));
    }
}
