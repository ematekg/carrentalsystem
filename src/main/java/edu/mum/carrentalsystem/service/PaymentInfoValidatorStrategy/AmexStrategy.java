package edu.mum.carrentalsystem.service.PaymentInfoValidatorStrategy;

import edu.mum.carrentalsystem.model.payment.PaymentInfo;
import org.springframework.stereotype.Service;

@Service
public class AmexStrategy extends APaymentInfoValidator {
    @Override
    public boolean isValid(PaymentInfo paymentInfo) {

        boolean isValid = true;

        if(isValid) {
            isValid = paymentInfo.getCardNumber().length() == 15;
        }

        isValid = paymentInfo.getCardNumber().startsWith("37") || paymentInfo.getCardNumber().startsWith("34");

        if(isValid) {
            isValid = passesLuhn(paymentInfo.getCardNumber());
        }


        return isValid;
    }
}
