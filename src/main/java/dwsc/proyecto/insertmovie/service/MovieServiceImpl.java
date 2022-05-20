package dwsc.proyecto.insertmovie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dwsc.proyecto.insertmovie.dao.MovieRepository;
import dwsc.proyecto.insertmovie.domain.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepo;

	public Optional<Movie> getMovie(String title, Integer year) {
		Optional<Movie> movie = movieRepo.findByTitleAndYear(title, year);
		return movie;
	}

	public void insertMovie(Movie movie) {
		movieRepo.save(movie);
	}

}
