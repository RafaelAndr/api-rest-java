package rafaelandrade.libraryapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rafaelandrade.libraryapi.model.Livro;
import rafaelandrade.libraryapi.model.Usuario;
import rafaelandrade.libraryapi.repository.LivroRepository;
import rafaelandrade.libraryapi.security.SecurityService;
import rafaelandrade.libraryapi.validator.LivroValidator;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository repository;
    private final LivroValidator validator;
    private final SecurityService securityService;

    public Livro salvar(Livro livro){
        validator.validar(livro);
        Usuario usuario = securityService.obterUsuarioLogado();
        livro.setIdUsuario(usuario.getId());
        return repository.save(livro);
    }

    public Optional<Livro> obterPorId(UUID id){
        return repository.findById(id);
    }

    public void deletar(Livro livro){
        repository.delete(livro);
    }

    public void atualizar(Livro livro) {
        if(livro.getId() == null){
            throw new IllegalArgumentException("Para atualizar, é necessário que o livro já esteja salvo na base.");
        }

        validator.validar(livro);
        repository.save(livro);
    }
}
