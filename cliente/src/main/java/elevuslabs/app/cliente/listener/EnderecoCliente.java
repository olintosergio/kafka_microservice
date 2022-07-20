package elevuslabs.app.cliente.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import elevuslabs.app.cliente.model.EnderecoModel;
import elevuslabs.app.cliente.service.EnderecoService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class EnderecoCliente {

    @Autowired
    private EnderecoService service;

    @KafkaListener(topics = "${topic.endereco-client}", groupId = "${spring.kafka.consumer.group-id}")
    public void obterEnderecoCliente(String enderecoString) throws JsonProcessingException {

        log.info("Mensagem endereço {}", enderecoString);

        // Lendo a mensagem em String e convertendo para Model e gravando no Banco
        ObjectMapper objectMapper = new ObjectMapper();
        EnderecoModel enderecoModel = objectMapper.readValue(enderecoString, EnderecoModel.class);

        service.save(enderecoModel);
        log.info("Endereço salvo na base de dados com sucesso: {}", enderecoModel);

    }
}
