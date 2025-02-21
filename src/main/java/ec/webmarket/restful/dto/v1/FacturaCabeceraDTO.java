package ec.webmarket.restful.dto.v1;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FacturaCabeceraDTO {
    private Long id;
    private Long clienteId;
    private Double total;
}