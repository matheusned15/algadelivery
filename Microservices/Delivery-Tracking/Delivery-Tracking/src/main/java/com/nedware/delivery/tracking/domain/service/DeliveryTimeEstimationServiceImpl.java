package com.nedware.delivery.tracking.domain.service;

import com.nedware.delivery.tracking.domain.model.ContactPoint;
import org.springframework.stereotype.Service;

import java.time.Duration;


@Service
public class DeliveryTimeEstimationServiceImpl implements DeliveryTimeEstimationService{
    @Override

    public DeliveryEstimate estimate(ContactPoint sender, ContactPoint receiver) {
        // TODO: substituir por sua lógica real (cálculo de distância, etc.)
        double distanceKm = 10.0;
        Duration eta = Duration.ofMinutes(45);
        return new DeliveryEstimate(eta, distanceKm);
    }

}
