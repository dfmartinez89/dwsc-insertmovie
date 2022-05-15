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

import dwsc.proyecto.insertmovie.domain.Movie;
import dwsc.proyecto.insertmovie.exceptions.CustomResponse;
import dwsc.proyecto.insertmovie.exceptions.MovieDuplicatedException;
import dwsc.proyecto.insertmovie.exceptions.MovieNotFoundException;
import dwsc.proyecto.insertmovie.service.MovieService;
import dwsc.proyecto.insertmovie.service.MovieServiceClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class InsertMovieController {
	@Autowired
	private MovieServiceClient movieClient;

	@Autowired
	private MovieService movieService;

	/**
	 * verify movie service response status code
	 */
	private int resCode;
	
	@Operation(summary = "Insert movie in database", description = "Operation to insert valid movie in database")
	@ApiResponses({ @ApiResponse(responseCode = "201", description = "movie inserted succesfully"),
			@ApiResponse(responseCode = "404", description = "movie not found", content = @Content(schema = @Schema(implementation = CustomResponse.class))) })
	@RequestMapping(method = RequestMethod.POST, path = "/movie", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie)
			throws Exception {
		String movieTitle = movie.getTitle();
		int movieYear = movie.getYear();
		try {
			// check if the movie exists in OMDb
			resCode = movieClient.checkMovie(movieTitle, movieYear).getStatusCodeValue();
			if (resCode == 404) {
				throw new MovieNotFoundException(HttpStatus.CONFLICT, "The movie " + movieTitle + " does not exists");
			}
		} catch (RuntimeException e) {
			throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Check-Movie Service is not available");
		}

		// check if the movie already exists in our DB
		Movie movieDb = movieService.getMovie(movieTitle, movieYear);
		if (movieDb != null) {
			throw new MovieDuplicatedException(HttpStatus.CONFLICT, "The movie " + movieTitle + " already exists");
		}
		
		try {
			movieService.insertMovie(movie);
		} catch (Exception e) {
			throw new Exception("An error has ocurred while inserting the movie" + e);
		}

		return new ResponseEntity<Movie>(movie, HttpStatus.CREATED); 
	}
}
