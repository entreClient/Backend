package com.upc.trabajo_final.Trabajo.Final.Entreclient.service.serviceImpl;

import com.upc.trabajo_final.Trabajo.Final.Entreclient.model.Delivery;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.repository.DeliveryRepository;
import com.upc.trabajo_final.Trabajo.Final.Entreclient.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public Delivery createDelivery(Delivery delivery){
        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery updateDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    @Override
    public Delivery getDeliveryById(int id) {
        Optional<Delivery> optional= deliveryRepository.findById(id) ;
        if(optional.isPresent()){
            return optional.get();
        }else{
            throw new RuntimeException("No existe delivery");
        }
    }

    @Override
    public void deleteDelivery(int id) {
        deliveryRepository.deleteById(id);
    }

    @Override
    public List<Delivery> getAllDelivery() {
        return (List<Delivery>) deliveryRepository.findAll();
    }

    @Override
    public boolean isDeliveryExists(int id) {
        return deliveryRepository.existsById(id);
    }

}
