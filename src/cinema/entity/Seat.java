package cinema.entity;

public class Seat {
    private static int idCounter = 1;
    private final int id;

    private final RowLabel row;
    private final int number;
    private SeatType type;

    public Seat(RowLabel row, int number) {
        this.id = idCounter++;
        this.row = row;
        this.number = number;
        this.type = SeatType.FREE;

        if (number <= 0) {
            throw new IllegalArgumentException("Seat number must be a positive natural number");
        }
    }

    public int getId() {return id;}

    public int getNumber() {return number;}
    public RowLabel getRow() {return row;}
    public SeatType getType() {return type;}
    public void setType(SeatType type) {this.type = type;}

    public boolean isFree(){
        return type == SeatType.FREE;
    }

    @Override
    public String toString() {
        return "Seat #" + id + "  [row=" + row + ", number=" + number + ", type=" + type + "]";
    }
}
