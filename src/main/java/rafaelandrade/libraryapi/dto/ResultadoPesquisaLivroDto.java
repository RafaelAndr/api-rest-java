package rafaelandrade.libraryapi.dto;

import rafaelandrade.libraryapi.model.Genero;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ResultadoPesquisaLivroDto (
        String isbn,
        String titulo,
        LocalDate dataPublicacao,
        Genero genero,
        BigDecimal preco,
        AutorDto autor,
        EditoraDto editora
    ){
}
