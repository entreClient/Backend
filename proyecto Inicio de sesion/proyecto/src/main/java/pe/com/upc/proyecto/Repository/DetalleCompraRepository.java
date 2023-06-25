package com.upc.trabajo_final.Trabajo.Final.Entreclient.repository;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.DetalleCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Integer> {
    @Query("SELECT dp FROM DetalleCompra dp " +
            "JOIN FETCH dp.pago p " +
            "JOIN FETCH p.cliente c " +
            "JOIN FETCH dp.producto pr " +
            "JOIN FETCH pr.categoria cat " +
            "JOIN FETCH pr.emprendimiento emp " +
            "JOIN FETCH emp.emprendedor empr " +
            "WHERE dp.id = :detallePagoId")
    DetalleCompra findDetallePagoWithRelations(@Param("detallePagoId") Integer detallePagoId);

}
