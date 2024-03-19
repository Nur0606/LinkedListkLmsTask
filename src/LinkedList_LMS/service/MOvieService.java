package LinkedList_LMS.service;

import LinkedList_LMS.enums.Genre;
import LinkedList_LMS.model.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MOvieService {
    List<Movie> getAllMovies();

    Movie findMovieByFullNameOrPartName(String name);

    Movie findMovieByActorName(String actorName);

    Movie findMovieByYear(LocalDate year);

    Movie findMovieByProducer(String producerFullName);

    Movie findMovieByGenre(Genre genre);

    Movie findMovieByRole(String role);
}
