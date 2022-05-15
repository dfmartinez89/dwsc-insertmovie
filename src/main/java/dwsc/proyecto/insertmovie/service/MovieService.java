package dwsc.proyecto.insertmovie.service;

import org.springframework.stereotype.Service;

import dwsc.proyecto.insertmovie.domain.Movie;

@Service
public interface MovieService {
	public Movie getMovie(String title, int year);

	public void insertMovie(Movie movie);

}
