package ec.webmarket.restful.api.v1;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ec.webmarket.restful.dto.v1.FacturaCabeceraDTO;
import ec.webmarket.restful.service.crud.FacturaCabeceraService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/facturas")
public class FacturaCabeceraController {

    private final FacturaCabeceraService facturaService;

    public FacturaCabeceraController(FacturaCabeceraService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<FacturaCabeceraDTO> listarFacturas() {
        return facturaService.listarFacturas();
    }

    @PostMapping
    public ResponseEntity<FacturaCabeceraDTO> crearFactura(@RequestBody FacturaCabeceraDTO facturaDTO) {
        return ResponseEntity.ok(facturaService.guardarFactura(facturaDTO));
    }
}