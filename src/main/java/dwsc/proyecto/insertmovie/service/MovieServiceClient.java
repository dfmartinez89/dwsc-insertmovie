package dwsc.proyecto.insertmovie.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient("VERIFYMOVIE")
public interface MovieServiceClient {
	@GetMapping("/{title}")
	public ResponseEntity<String> checkMovie(@PathVariable String title, @RequestParam(required = false) Integer year);
}
