package edu.mum.carrentalsystem.service.PaymentInfoValidatorStrategy;

import edu.mum.carrentalsystem.model.payment.PaymentInfo;
import edu.mum.carrentalsystem.service.IPaymentInfoValidator;
import edu.mum.carrentalsystem.service.PaymentInfoValidatorStrategy.strategy.CardcheckStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmexStrategy implements CardcheckStrategies {
    @Autowired
    private IPaymentInfoValidator paymentInfoValidator;

    public boolean isValid(PaymentInfo paymentInfo) {

        boolean isValid = true;

        if(isValid) {
            isValid = paymentInfo.getCardNumber().length() == 15;
        }

        isValid = paymentInfo.getCardNumber().startsWith("37") || paymentInfo.getCardNumber().startsWith("34");

        if(isValid) {
            isValid = paymentInfoValidator.passesLuhn(paymentInfo);
        }


        return isValid;
    }
}
