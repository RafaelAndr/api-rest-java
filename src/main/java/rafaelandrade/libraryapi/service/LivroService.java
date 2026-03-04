package rafaelandrade.libraryapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rafaelandrade.libraryapi.model.Livro;
import rafaelandrade.libraryapi.repository.LivroRepository;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository repository;

    public Livro salvar(Livro livro){
        return repository.save(livro);
    }
}
