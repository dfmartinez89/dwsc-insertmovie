package dwsc.proyecto.insertmovie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dwsc.proyecto.insertmovie.dao.MovieRepository;
import dwsc.proyecto.insertmovie.domain.Movie;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MovieService {
	private final MovieRepository movieRepo = null;
	
	public Movie getMovie(String title, int year) {
		Optional<List<Movie>> movie = Optional.ofNullable((movieRepo.findByTitleAndYear(title, year)));
		return (Movie) movie.get();
	}
}
