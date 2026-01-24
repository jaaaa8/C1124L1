package com.example.service.impl;

public interface IConvertService {
    double convertToVnd(double usdAmount, double exchangeRate);
    double convertToUsd(double vndAmount, double exchangeRate);
}
