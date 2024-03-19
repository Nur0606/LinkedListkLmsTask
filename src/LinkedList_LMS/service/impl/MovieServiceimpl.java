package LinkedList_LMS.service.impl;

import LinkedList_LMS.db.Database;
import LinkedList_LMS.enums.Genre;
import LinkedList_LMS.model.Actor;
import LinkedList_LMS.model.Movie;
import LinkedList_LMS.service.MOvieService;

import java.time.LocalDate;
import java.util.List;

public class MovieServiceimpl implements MOvieService {
    @Override
    public List<Movie> getAllMovies() {
        return Database.getMovie;
    }

    @Override
    public Movie findMovieByFullNameOrPartName(String name) {
        for (Movie movie : Database.getMovie) {
            if (movie.getName().equals(name)) {
                return movie;
            }

        }
        System.out.println("Not-Found");
        return null;
    }

    @Override
    public Movie findMovieByActorName(String actorName) {
        for (Movie movie : Database.getMovie) {
            for (Actor actor : movie.getActors()) {
                if (actor.getActorFullName().equalsIgnoreCase(actorName)) {
                    return movie;
                }
            }
        }
        System.out.println("Actor name Not-Found!");
        return null;
    }

    @Override
    public Movie findMovieByYear(LocalDate year) {
        for (Movie movie : Database.getMovie) {
            if (movie.getYear().equals(year)) {
                return movie;
            }
        }
        System.out.println("Year Not Correct!");
        return null;
    }

    @Override
    public Movie findMovieByProducer(String producerFullName) {
        for (Movie movie : Database.getMovie) {
            if (movie.getProducer().getFirstName().equals(producerFullName) || movie.getProducer().getLastName().equals(producerFullName)) {
                return movie;
            }

        }
        System.out.println("Full Name Not Correct!");
        return null;
    }

    @Override
    public Movie findMovieByGenre(Genre genre) {
        for (Movie movie : Database.getMovie) {
            if (movie.getGenre().equals(genre)) {
                return movie;
            }
        }

        System.out.println("Genre Not Found!");
        return null;
    }

    @Override
    public Movie findMovieByRole(String role) {
        for (Movie movie : Database.getMovie) {
            for (Actor actor : movie.getActors()) {
                if (actor.getRole().equals(role)) {
                    return movie;
                }

            }
        }
        System.out.println("Role Not-Found!");
        return null;
    }
}
