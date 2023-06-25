package com.upc.trabajo_final.Trabajo.Final.Entreclient.repository;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.MetodoEnvio;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.MetodoPago;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Compra;
import com.upc.trabajo_final.Trabajo.Final.security.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Integer> {
    @Query("SELECT cl FROM Compra c JOIN c.cliente cl WHERE c.id = :compraId")
    Cliente findClienteByCompraId(@Param("compraId") Integer compraId);

    @Query("SELECT mp FROM Compra c JOIN c.metodoPago mp WHERE c.id = :compraId")
    MetodoPago findMetodoPagoByCompraId(@Param("compraId") Integer compraId);

    @Query("SELECT me FROM Compra c JOIN c.metodoEnvio me WHERE c.id = :compraId")
    MetodoEnvio findMetodoEnvioByCompraId(@Param("compraId") Integer compraId);

}
