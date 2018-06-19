package edu.mum.carrentalsystem.service.PaymentInfoValidatorStrategy;

import edu.mum.carrentalsystem.model.payment.PaymentInfo;
import org.springframework.stereotype.Service;

@Service
public class VisaStrategy extends APaymentInfoValidator {
    @Override
    public boolean isValid(PaymentInfo paymentInfo) {
        boolean isValid = true;

        isValid = paymentInfo.getCardNumber().startsWith("4");

        if(isValid) {
            isValid = paymentInfo.getCardNumber().length() == 16;
        }

        if(isValid) {
            isValid = passesLuhn(paymentInfo.getCardNumber());
        }

        return isValid;
    }
}
