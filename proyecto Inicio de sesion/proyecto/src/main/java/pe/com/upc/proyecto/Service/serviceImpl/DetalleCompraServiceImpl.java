package com.upc.trabajo_final.Trabajo.Final.Entreclient.service.serviceImpl;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.DetalleCompra;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.DetalleCompraRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.DetalleCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService {
    @Autowired
    private DetalleCompraRepository detallePagoRepository;

    @Override
    public DetalleCompra createDetallePago(DetalleCompra detallePago) {
        return detallePagoRepository.save(detallePago);
    }

    @Override
    public void updateDetallePago(DetalleCompra detallePago) {
        detallePagoRepository.save(detallePago);
    }

    @Override
    public void deleteDetallePago(int id) {
        detallePagoRepository.deleteById(id);
    }

    @Override
    public DetalleCompra getDetallePagoById(int id) {
        Optional<DetalleCompra> optional = detallePagoRepository.findById(id);
        if(optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("DetallePago not found for id : " + id);
        }
    }

    @Override
    public List<DetalleCompra> getAllDetallePago() {
        return (List<DetalleCompra>) detallePagoRepository.findAll();
    }

    @Override
    public boolean isDetallePagoExists(int id) {
        return detallePagoRepository.existsById(id);
    }
}
