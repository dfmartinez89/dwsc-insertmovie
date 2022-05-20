package dwsc.proyecto.insertmovie.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dwsc.proyecto.insertmovie.domain.Movie;

@Service
public interface MovieService {
	public Optional<Movie> getMovie(String title, Integer year);

	public void insertMovie(Movie movie);

}
