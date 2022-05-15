package dwsc.proyecto.insertmovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dwsc.proyecto.insertmovie.dao.MovieRepository;
import dwsc.proyecto.insertmovie.domain.Movie;
import dwsc.proyecto.insertmovie.exceptions.MovieDuplicatedException;
import dwsc.proyecto.insertmovie.exceptions.MovieNotFoundException;
import dwsc.proyecto.insertmovie.service.MovieServiceClient;

@RestController
public class InsertMovieController {
	@Autowired
	private MovieServiceClient movieClient;
	
	
	/**
	 * verify movie service response status code
	 */
	private int resCode;

	@RequestMapping(method = RequestMethod.GET, path = "/movie", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) throws MovieDuplicatedException {
		String movieTitle = movie.getTitle();
		String movieYear = String.valueOf(movie.getYear());
		Boolean isValidMovie = false;
		try {
			 resCode = movieClient.checkMovie(movieTitle, movieYear).getStatusCodeValue();
			 if (resCode == 404) {
				 throw new MovieNotFoundException(HttpStatus.CONFLICT, "The movie " + movieTitle + " does not exists");
			} 
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Check-Movie Service is not available");
		}
		
		

		if (isValidMovie) {
			throw new MovieDuplicatedException(HttpStatus.CONFLICT, "The movie " + movieTitle + " already exists");
		}

		return ResponseEntity.ok(movie);
	}
}
