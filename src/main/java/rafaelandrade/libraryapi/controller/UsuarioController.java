package rafaelandrade.libraryapi.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rafaelandrade.libraryapi.dto.UsuarioDto;
import rafaelandrade.libraryapi.mappers.UsuarioMapper;
import rafaelandrade.libraryapi.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;
    private final UsuarioMapper mapper;

    @PostMapping
    public void salvar(@RequestBody @Valid UsuarioDto dto){
        var usuario = mapper.toEntity(dto);
        service.salvar(usuario);
    }
}
