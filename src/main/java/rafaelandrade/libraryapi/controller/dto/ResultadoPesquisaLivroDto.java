package rafaelandrade.libraryapi.controller.dto;

import rafaelandrade.libraryapi.model.Genero;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ResultadoPesquisaLivroDto (
        String isbn,
        String titulo,
        LocalDate dataPublicacao,
        Genero genero,
        BigDecimal preco,
        AutorDto idAutor
    ){

}
