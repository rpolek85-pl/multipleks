package cinema.factory;

import cinema.entity.MoveType;
import cinema.entity.Movie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovieFactory {

    private static final List<String> MOVIES = List.of(
            "Inception",
            "Interstellar",
            "The Dark Knight",
            "Pulp Fiction",
            "The Matrix",
            "Forrest Gump",
            "The Shawshank Redemption",
            "Gladiator",
            "The Lord of the Rings",
            "Fight Club",
            "Avatar",
            "Titanic",
            "The Godfather",
            "Jurassic Park",
            "Star Wars: A New Hope",
            "Mad Max: Fury Road",
            "La La Land",
            "Whiplash",
            "The Prestige",
            "Dune"
    );

    public static Movie createRandomMovie() {
        List<String> COPY_MOVIES = new ArrayList<>(MOVIES);
        Collections.shuffle(COPY_MOVIES);

        int randomDurationMinutes = (int) (Math.random() * 100) + 100;
        int randomIntMoveType = (int) (Math.random() * 10);

        Movie movie = new Movie(COPY_MOVIES.getFirst(), MoveType.values()[randomIntMoveType], randomDurationMinutes);

        return movie;
    }
}
