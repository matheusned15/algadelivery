package com.nedware.delivery.tracking.domain.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CourierPayoutCalculationServiceImpl implements CourierPayoutCalculationService{
    @Override

    public BigDecimal calculatePayout(Double distanceInKm) {
        // TODO: sua regra real de payout; abaixo é só ilustrativo
        BigDecimal base = new BigDecimal("5.00");
        BigDecimal porKm = new BigDecimal("2.00");
        return base.add(porKm.multiply(BigDecimal.valueOf(distanceInKm)))
                .setScale(2, RoundingMode.HALF_EVEN);
    }

}
