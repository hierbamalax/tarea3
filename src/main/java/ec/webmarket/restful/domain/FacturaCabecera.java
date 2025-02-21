package ec.webmarket.restful.domain;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "factura_cabecera")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacturaCabecera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    private Double total;
}
