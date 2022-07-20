package elevuslabs.app.cliente.controller;

import elevuslabs.app.cliente.model.EnderecoModel;
import elevuslabs.app.cliente.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoModel> saveEndereco(@RequestBody EnderecoModel enderecoModel) {

        enderecoService.save(enderecoModel);
        return ResponseEntity.ok(enderecoModel);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoModel>> getListEndereco() {
        List<EnderecoModel> listaEndereco = enderecoService.getListEnderecos();

        return ResponseEntity.ok(listaEndereco);
    }
}
