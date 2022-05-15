package dwsc.proyecto.insertmovie.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class MovieDuplicatedException extends ResponseStatusException{
	private static final long serialVersionUID = 1L;

	public MovieDuplicatedException(HttpStatus code, String message) {
		super(code, message);
	}
}
