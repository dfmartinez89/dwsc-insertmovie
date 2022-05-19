package dwsc.proyecto.insertmovie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dwsc.proyecto.insertmovie.dao.MovieRepository;
import dwsc.proyecto.insertmovie.domain.Movie;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepo;

	public List<Movie> getMovie(String title) {
		List<Movie> movie = movieRepo.findByTitle(title);
		return movie;
	}

	public void insertMovie(Movie movie) {
		movieRepo.save(movie);
	}

}
