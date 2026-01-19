package com.nedware.delivery.tracking.domain.service;


import com.nedware.delivery.tracking.domain.model.ContactPoint;
import org.springframework.stereotype.Service;

public interface DeliveryTimeEstimationService {
    DeliveryEstimate estimate(ContactPoint sender, ContactPoint receiver);
}