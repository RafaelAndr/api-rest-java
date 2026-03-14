package rafaelandrade.libraryapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rafaelandrade.libraryapi.model.Client;
import rafaelandrade.libraryapi.repository.ClientRepository;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public Client salvar(Client client){
        return repository.save(client);
    }

    public Client obterPorIdClient(String clientId){
        return repository.findByClientId(clientId);
    }
}
