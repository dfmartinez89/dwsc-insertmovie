package dwsc.proyecto.insertmovie.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import dwsc.proyecto.insertmovie.domain.Movie;

@RepositoryRestResource(collectionResourceRel = "movie", path = "movie")
public interface MovieRepository extends MongoRepository<Movie, String> {
	Optional<Movie> findByTitleAndYear(@Param("title") String title, @Param("year") Integer year);
}
