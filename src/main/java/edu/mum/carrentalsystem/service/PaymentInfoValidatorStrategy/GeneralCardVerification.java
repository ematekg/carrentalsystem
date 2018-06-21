package edu.mum.carrentalsystem.service.PaymentInfoValidatorStrategy;

import edu.mum.carrentalsystem.model.payment.PaymentInfo;
import edu.mum.carrentalsystem.service.IPaymentInfoValidator;
import edu.mum.carrentalsystem.service.PaymentInfoValidatorStrategy.strategy.CardcheckStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GeneralCardVerification implements CardcheckStrategies {

    @Autowired
    private IPaymentInfoValidator paymentInfoValidator;
    public boolean isValid(PaymentInfo paymentInfo) {

        LocalDate expireDate = paymentInfo.getExpireDate();
        if(expireDate.isBefore(LocalDate.now())){
            return false;
        }

        return paymentInfoValidator.passesLuhn(paymentInfo);

    }

    public void setPaymentInfoValidator(IPaymentInfoValidator paymentInfoValidator) {
        this.paymentInfoValidator = paymentInfoValidator;
    }
}
