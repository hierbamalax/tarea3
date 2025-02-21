package ec.webmarket.restful.dto.v1;
import lombok.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private Long id;
    private String nombre;
    private Double precio;
    private Integer stock;
}