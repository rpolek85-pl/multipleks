package cinema.entity;

import java.util.List;

public class Cinema {
    private static int idCounter = 1;
    private final int id;

    private String name;
    private String address;
    private final List<CinemaHall> cinemaHalls;
    private List<FilmScreening> filmScreenings;

    public Cinema(String name, String address, List<CinemaHall> cinemaHalls) {
        this.id = idCounter++;
        this.name = name;
        this.address = address;
        this.cinemaHalls = cinemaHalls;
    }

    public int getId() {return id;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}
    public List<CinemaHall> getCinemaHalls() {return cinemaHalls;}

    public void addCinemaHall(CinemaHall cinemaHall){
        this.cinemaHalls.add(cinemaHall);
    }

    public List<FilmScreening> getFilmScreenings() {return filmScreenings;}
    public void addFilmScreening(FilmScreening filmScreening){this.filmScreenings.add(filmScreening);}

    public void setFilmScreenings(List<FilmScreening> filmScreenings){
        this.filmScreenings = filmScreenings;
    }

    public String toString(){
        return "Cinema #" + id + " " + name + ", " + address;
    }

}
