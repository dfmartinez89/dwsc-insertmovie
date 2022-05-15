package dwsc.proyecto.insertmovie.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Document
@NoArgsConstructor  
@AllArgsConstructor
public class Movie {
	@Id
	private @Getter @Setter String id;
	@NonNull 
	private @Getter @Setter String title;
	@NonNull 
	private @Getter @Setter int year;
	private @Getter @Setter int averageScore;
	private @Getter @Setter String description;
	private @Getter @Setter String url;

}
