package com.example.service;

import com.example.service.impl.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {
    @Override
    public double convertToVnd(double usdAmount, double exchangeRate) {
        return usdAmount * exchangeRate;
    }

    @Override
    public double convertToUsd(double vndAmount, double exchangeRate) {
        return vndAmount * exchangeRate;
    }
}
