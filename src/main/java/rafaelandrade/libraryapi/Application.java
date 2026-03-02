package rafaelandrade.libraryapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import rafaelandrade.libraryapi.model.Autor;
import rafaelandrade.libraryapi.repository.AutorRepository;

import java.time.LocalDate;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		var context = SpringApplication.run(Application.class, args);

	}

}
