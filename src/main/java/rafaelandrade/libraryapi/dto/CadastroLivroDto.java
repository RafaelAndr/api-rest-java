package rafaelandrade.libraryapi.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.ISBN;
import rafaelandrade.libraryapi.model.Genero;
import rafaelandrade.libraryapi.model.Livro;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record CadastroLivroDto(
        //@ISBN
        @NotBlank(message = "Campo obrigatório")
        String isbn,
        @NotBlank(message = "Campo obrigatório")
        String titulo,
        @NotNull(message = "Campo obrigatório")
        @Past(message = "Não pode ser uma data futura")
        LocalDate dataPublicacao,
        Genero genero,
        BigDecimal preco,
        @NotNull(message = "Campo obrigatório")
        UUID idAutor,
        @NotNull(message = "Campo obrigatório")
        UUID idEditora
) {
}
