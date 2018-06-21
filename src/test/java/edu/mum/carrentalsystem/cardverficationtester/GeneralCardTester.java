package edu.mum.carrentalsystem.cardverficationtester;


import edu.mum.carrentalsystem.model.payment.PaymentInfo;
import edu.mum.carrentalsystem.service.IPaymentInfoValidator;
import edu.mum.carrentalsystem.service.PaymentInfoValidatorStrategy.GeneralCardVerification;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class GeneralCardTester {
    private IPaymentInfoValidator paymentInfoValidator;
    private PaymentInfo paymentInfo;
    private GeneralCardVerification generalCardVerification;
    @Before
    public void setUp() throws Exception {
        paymentInfo=null;
        generalCardVerification=new GeneralCardVerification();


        paymentInfoValidator=mock(IPaymentInfoValidator.class);
        generalCardVerification.setPaymentInfoValidator(paymentInfoValidator);

    }

    @After
    public void tearDown() throws Exception {
        paymentInfo=null;

    }

    @Test
    public void reverseArray() {
        paymentInfo=new PaymentInfo("4567383986",LocalDate.of(2012,05,12),546);
        when(paymentInfoValidator.passesLuhn(paymentInfo)).thenReturn(true);

boolean b=generalCardVerification.isValid(paymentInfo);



      assertEquals(b,false);


    }
}