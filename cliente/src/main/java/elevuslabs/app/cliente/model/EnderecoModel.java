package elevuslabs.app.cliente.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class EnderecoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String cep;

    @Column
    private String logradouro;

    @Column
    private String complemento;

    @Column
    private String bairro;

    @Column
    private String localidade;

    @Column
    private String uf;

    @Column
    private Long numero;
}
