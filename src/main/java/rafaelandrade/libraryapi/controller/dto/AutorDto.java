package rafaelandrade.libraryapi.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import rafaelandrade.libraryapi.model.Autor;

import java.time.LocalDate;
import java.util.UUID;

public record AutorDto(
        UUID id,
        @NotBlank(message = "Campo obrigatório") //impede strings vazias
        @Size(min = 2, max = 100, message = "Tamanho fora do padrão")
        String nome,
        @NotNull(message = "Campo obrigatório")
        @Past(message = "Data deve estar no passado")
        LocalDate dataNascimento,
        @NotBlank(message = "Campo obrigatório")
        @Size(min = 2, max = 100, message = "Tamanho fora do padrão")
        String nacionalidade
) {

    public Autor mapearParaAutor(){
        Autor autor = new Autor();
        autor.setNome(this.nome);
        autor.setDataNascimento(this.dataNascimento);
        autor.setNacionalidade(this.nacionalidade);
        return autor;
    }
}
