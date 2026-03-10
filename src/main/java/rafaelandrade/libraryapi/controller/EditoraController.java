package rafaelandrade.libraryapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rafaelandrade.libraryapi.dto.EditoraDto;
import rafaelandrade.libraryapi.mappers.EditoraMapper;
import rafaelandrade.libraryapi.model.Editora;
import rafaelandrade.libraryapi.service.EditoraService;

import java.net.URI;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/editoras")
public class EditoraController implements GenericController {

    private final EditoraMapper mapper;
    private final EditoraService service;

    @PostMapping
    public ResponseEntity<Object> salvar(@RequestBody @Valid EditoraDto dto){
        Editora editora = mapper.toEntity(dto);

        service.salvar(editora);
        URI location = gerarHeaderLocation(editora.getId());

        return ResponseEntity.created(location).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<EditoraDto> obterDetalhes(@PathVariable("id") String id){
        var idEditora = UUID.fromString(id);

        return service
                .obterPorId(idEditora)
                .map(
                editora -> {
                    EditoraDto dto = mapper.toDto(editora);
                    return ResponseEntity.ok(dto);
                }).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
