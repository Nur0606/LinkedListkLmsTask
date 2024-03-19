import LinkedList_LMS.db.Database;
import LinkedList_LMS.enums.Genre;
import LinkedList_LMS.model.Actor;
import LinkedList_LMS.model.Movie;
import LinkedList_LMS.model.Producer;
import LinkedList_LMS.service.MOvieService;
import LinkedList_LMS.service.MovieSortableService;
import LinkedList_LMS.service.impl.MovieServiceimpl;
import LinkedList_LMS.service.impl.MovieSortableServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Producer producer1 = new Producer("abdipattaeva","nurtilekayim");
        Producer producer2 = new Producer("rusbaev","nurmuhammed");
        List<Actor> actors = new ArrayList<>(Arrays.asList(
                new Actor("abdipattaeva nurtilekayim","lysyi"),
                new Actor("rusbaev nurmuhammed ","glavnyi"),
                new Actor("adylmusaeva","nishiy")
        ));
        List < Movie> movies = new ArrayList<>(Arrays.asList(
                new Movie("50 оттенков серого", LocalDate.of(2015,11,22), Genre.romance,producer1,actors),
                new Movie("beish enenin tamanynda", LocalDate.of(2024,3,1), Genre.streets,producer1,actors),
                new Movie("ano", LocalDate.of(2023,4,8), Genre.animal,producer2,actors),
                new Movie("zima ne budet", LocalDate.of(2015,12,16), Genre.plantus,producer2,actors),
                new Movie("chyk eshike", LocalDate.of(2021,6,28), Genre.cars,producer1,actors)
        ));
        Database.getMovie.addAll(movies);

        MOvieService movieService = new MovieServiceimpl();
        MovieSortableService movieSortableService = new MovieSortableServiceImpl();


        System.out.println("   Welcome!  ");
        while (true){
            System.out.println("""
                    1.Get All Movie
                    2.Find Movie By Full Name or Part Name
                    3.Find Movie By Actor Name
                    4.Find Movie By Year
                    5.Find Movie By Producer Name
                    6.Find Movie By Genre
                    7.Find Movie By Role
                    __________________
                        Sort Movie
                    8.Sort Movie By Name
                    9.Sort By Year
                    10.Sort By Producer
                    """);
            switch (scanner.nextInt()){
                case 1-> System.out.println(movieService.getAllMovies());
                case 2->{
                    System.out.println("Enter Movie Name: ");
                    String name = scanner.next();
                    System.out.println(movieService.findMovieByFullNameOrPartName(name));
                }
                case 3->{
                    System.out.println("Enter Actor Name: ");
                    String name = scanner.next();
                    System.out.println(movieService.findMovieByActorName(name));
                }
                case 4->{
                    System.out.println("Enter Movie Year: ");
                     int year = scanner.nextInt();
                    System.out.println("Enter Movie Month: ");
                    int ay = scanner.nextInt();
                    System.out.println("Enter Movie Day: ");
                    int day = scanner.nextInt();
                    System.out.println(movieService.findMovieByYear(LocalDate.of(year, ay, day)));
                }
                case 5->{
                    System.out.println("Enter Movie By Producer Name: ");
                    String name = scanner.next();
                    System.out.println(movieService.findMovieByProducer(name));
                }
                case 6->{
                    System.out.println("""
                            Enter Movie By Genre:  эгер билбесен ушул жанырлар бар:
                              (romance,plantus, kaktus,animal,streets,cars,plays)
                            """);
                    Genre genre = Genre.valueOf(scanner.next());
                    System.out.println(movieService.findMovieByGenre(genre));
                }
                case 7->{
                    System.out.println("Enter Movie By Role: ");
                    String role = scanner.next();
                    System.out.println(movieService.findMovieByRole(role));
                }
                case 8->{
                    System.out.println("Enter Movie By Sort Name:(asc/desc)");
                    String sortNameAscOrDesc = scanner.next();
                    movieSortableService.sortMovieByName(sortNameAscOrDesc);
                    System.out.println(movieSortableService);
                }
                case 9-> {
                    System.out.println("Enter Movie By Sort Year:(asc/desc)");
                    String sortYearAscOrDesc = scanner.next();
                    movieSortableService.sortByYear(sortYearAscOrDesc);
                    System.out.println(movieSortableService);
                }
                case 10->{
                    System.out.println("Enter Movie Sort By Producer Name:(name/lastname)");
                    String name = scanner.next();
                    movieSortableService.sortByProducer(name);
                    System.out.println(movieSortableService);
                }
                default -> System.out.println("Такое число нет родной думай!");
            }
        }
    }

}