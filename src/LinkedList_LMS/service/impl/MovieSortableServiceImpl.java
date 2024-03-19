package LinkedList_LMS.service.impl;

import LinkedList_LMS.db.Database;
import LinkedList_LMS.model.Movie;
import LinkedList_LMS.model.Producer;
import LinkedList_LMS.service.MovieSortableService;

import java.util.Collections;
import java.util.Comparator;

public class MovieSortableServiceImpl implements MovieSortableService {

    @Override
    public void sortMovieByName(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            Comparator<Movie> movieComparator = Comparator.comparing(Movie::getName);
            Database.getMovie.sort(movieComparator);
            System.out.println(Database.getMovie);

        } else if (ascOrDesc.equalsIgnoreCase("desc")) {
            Comparator<Movie> movieComparator = Comparator.comparing(Movie::getName).reversed();
            Database.getMovie.sort(movieComparator);
            System.out.println(Database.getMovie);
        }else
            System.out.println("Tuura ber Rodnoi!");
    }

    @Override
    public void sortByYear(String ascOrDesc) {
        if ("asc".equalsIgnoreCase(ascOrDesc)){
            Comparator<Movie> movieComparator = Comparator.comparing(Movie::getYear);
            Database.getMovie.sort(movieComparator);
            System.out.println(Database.getMovie);
        } else if (ascOrDesc.equalsIgnoreCase("desc")) {
            Comparator<Movie> movieComparator = Comparator.comparing(Movie::getYear).reversed();
            Database.getMovie.sort(movieComparator);
            System.out.println(Database.getMovie);
        }else
            System.out.println("Tuura ber Rodnoi!");
    }

    @Override
    public void sortByProducer(String nameOrLastName) {
        if (nameOrLastName.equalsIgnoreCase("name")) {
            Database.getMovie.sort(Comparator.comparing(movie -> movie.getProducer().getFirstName()));
            System.out.println(Database.getMovie);
        } else if (nameOrLastName.equalsIgnoreCase("lastname")) {
            Database.getMovie.sort(Comparator.comparing(movie -> movie.getProducer().getLastName()));
            System.out.println(Database.getMovie);
        }

    }
}
