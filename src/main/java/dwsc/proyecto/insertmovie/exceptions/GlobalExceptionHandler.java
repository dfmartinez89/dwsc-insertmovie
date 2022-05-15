package dwsc.proyecto.insertmovie.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MovieNotFoundException.class)
	public ResponseEntity<CustomResponse> movietNotFound(RuntimeException ex) {
		CustomResponse resp = new CustomResponse();
		resp.setTimestamp(LocalDateTime.now());
		resp.setError(ex.getMessage());
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MovieDuplicatedException.class)
	public ResponseEntity<CustomResponse> movieDuplicated(RuntimeException ex) {
		CustomResponse resp = new CustomResponse();
		resp.setTimestamp(LocalDateTime.now());
		resp.setError(ex.getMessage());
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}

}
