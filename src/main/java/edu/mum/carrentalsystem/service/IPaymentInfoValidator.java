package edu.mum.carrentalsystem.service;

import edu.mum.carrentalsystem.model.payment.PaymentInfo;

public interface IPaymentInfoValidator {
    public boolean isValid(PaymentInfo paymentInfo);
}
