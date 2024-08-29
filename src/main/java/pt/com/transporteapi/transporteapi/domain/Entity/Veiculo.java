package pt.com.transporteapi.transporteapi.domain.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String modelo;
    private String placa;
    private double capacidade;
    private boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;


}
