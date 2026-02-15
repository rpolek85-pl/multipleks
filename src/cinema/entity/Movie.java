package cinema.entity;

public class Movie {
    private final String title;
    private final MoveType type;
    private final int durationMinutes;

    public Movie(String title, MoveType type, int durationMinutes) {
        if (durationMinutes <= 0) {
            throw new IllegalArgumentException("Duration Minutes movie must be a positive natural number");
        }

        this.title = title;
        this.type = type;
        this.durationMinutes = durationMinutes;
    }

    public String getTitle() {return title;}
    public MoveType getType() {return type;}
    public int getDurationMinutes() {return durationMinutes;}

    @Override
    public String toString() {
        return "Movie [title=" + title + ", type=" + type + ", duration=" + durationMinutes + "]";
    }

}
