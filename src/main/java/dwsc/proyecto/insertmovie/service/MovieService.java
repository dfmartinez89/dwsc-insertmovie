package dwsc.proyecto.insertmovie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dwsc.proyecto.insertmovie.domain.Movie;

@Service
public interface MovieService {
	public List<Movie> getMovie(String title);

	public void insertMovie(Movie movie);

}
