package rafaelandrade.libraryapi.controller.dto;

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
        UUID idAutor
) {
//    public Livro mapearParaLivro(){
//        Livro livro = new Livro();
//        livro.setIsbn(this.isbn);
//        livro.setTitulo(this.titulo);
//        livro.setDataPublicacao(this.dataPublicacao);
//        livro.setGenero(this.genero);
//        livro.setPreco(this.preco);
//        //livro.setIdAutor(this.idAutor);
//    }
}
