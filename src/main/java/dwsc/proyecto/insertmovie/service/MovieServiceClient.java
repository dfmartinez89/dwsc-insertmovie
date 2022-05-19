package dwsc.proyecto.insertmovie.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient("VERIFY-MOVIE")
public interface MovieServiceClient {
	@GetMapping("/{title}")
	public ResponseEntity<String> checkMovie(@PathVariable String title);
}
