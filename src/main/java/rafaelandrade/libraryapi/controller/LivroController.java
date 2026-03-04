package rafaelandrade.libraryapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rafaelandrade.libraryapi.controller.dto.CadastroLivroDto;
import rafaelandrade.libraryapi.controller.dto.ErroResposta;
import rafaelandrade.libraryapi.controller.mappers.LivroMapper;
import rafaelandrade.libraryapi.exceptions.RegistroDuplicadoExceptions;
import rafaelandrade.libraryapi.model.Livro;
import rafaelandrade.libraryapi.service.LivroService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/livros")
public class LivroController {

    private final LivroService service;
    private final LivroMapper mapper;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid CadastroLivroDto dto){
        try{
            Livro livro = mapper.toEntity(dto);
            service.salvar(livro);
            return ResponseEntity.ok(livro);
        } catch(RegistroDuplicadoExceptions e){
            var erroDTO = ErroResposta.conflito(e.getMessage());
            return ResponseEntity.status(erroDTO.status()).body(erroDTO);
        }
    }
}
