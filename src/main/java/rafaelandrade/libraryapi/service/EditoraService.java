package rafaelandrade.libraryapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rafaelandrade.libraryapi.model.Editora;
import rafaelandrade.libraryapi.repository.EditoraRepository;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EditoraService {

    private final EditoraRepository repository;

    public void salvar(Editora editora) {
        repository.save(editora);
    }

    public Optional<Editora> obterPorId(UUID id) {
        return repository.findById(id);
    }
}
