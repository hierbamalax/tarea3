package ec.webmarket.restful.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.webmarket.restful.domain.FacturaCabecera;

import java.util.List;

@Repository
public interface FacturaCabeceraRepository extends JpaRepository<FacturaCabecera, Long> {
    List<FacturaCabecera> findByClienteId(Long clienteId);
}