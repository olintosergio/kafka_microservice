package elevuslabs.app.cliente.service;

import elevuslabs.app.cliente.model.EnderecoModel;
import elevuslabs.app.cliente.repository.EnderecoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoRepository repository;

    @Transactional
    public EnderecoModel save(EnderecoModel enderecoModel) {

        return repository.save(enderecoModel);
    }

    public List<EnderecoModel> getListEnderecos() {

        return repository.findAll();
    }
}
