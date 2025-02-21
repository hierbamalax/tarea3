package ec.webmarket.restful.service.crud;

import org.springframework.stereotype.Service;

import ec.webmarket.restful.domain.Cliente;
import ec.webmarket.restful.domain.FacturaCabecera;
import ec.webmarket.restful.dto.v1.FacturaCabeceraDTO;
import ec.webmarket.restful.persistence.ClienteRepository;
import ec.webmarket.restful.persistence.FacturaCabeceraRepository;

import java.util.List;

@Service
public class FacturaCabeceraService {

    private final FacturaCabeceraRepository facturaCabeceraRepository;
    private final ClienteRepository clienteRepository;

    public FacturaCabeceraService(FacturaCabeceraRepository facturaCabeceraRepository, ClienteRepository clienteRepository) {
        this.facturaCabeceraRepository = facturaCabeceraRepository;
        this.clienteRepository = clienteRepository;
    }

    public List<FacturaCabeceraDTO> listarFacturas() {
        return facturaCabeceraRepository.findAll().stream()
                .map(this::convertirAFacturaCabeceraDTO)
                .toList();
    }

    public FacturaCabeceraDTO guardarFactura(FacturaCabeceraDTO facturaDTO) {
        Cliente cliente = clienteRepository.findById(facturaDTO.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        FacturaCabecera factura = new FacturaCabecera();
        factura.setCliente(cliente);
        factura.setTotal(facturaDTO.getTotal());

        FacturaCabecera facturaGuardada = facturaCabeceraRepository.save(factura);
        return convertirAFacturaCabeceraDTO(facturaGuardada);
    }

    private FacturaCabeceraDTO convertirAFacturaCabeceraDTO(FacturaCabecera factura) {
        return new FacturaCabeceraDTO(
                factura.getId(),
                factura.getCliente().getId(),
                factura.getTotal()
        );
    }
}