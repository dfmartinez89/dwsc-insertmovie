package dwsc.proyecto.insertmovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InsertMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsertMovieApplication.class, args);
	}

}
