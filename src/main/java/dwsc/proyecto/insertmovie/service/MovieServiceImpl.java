package dwsc.proyecto.insertmovie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dwsc.proyecto.insertmovie.dao.MovieRepository;
import dwsc.proyecto.insertmovie.domain.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	private MovieRepository movieRepo;

	public Movie getMovie(String title, int year) {
		Optional<List<Movie>> movie = Optional.ofNullable((movieRepo.findByTitleAndYear(title, year)));
		return (Movie) movie.get();
	}

	public void insertMovie(Movie movie) {
		movieRepo.save(movie);
	}

}
