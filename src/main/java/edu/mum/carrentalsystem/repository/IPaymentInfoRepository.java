package edu.mum.carrentalsystem.repository;

import edu.mum.carrentalsystem.model.payment.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentInfoRepository extends JpaRepository<PaymentInfo,Long> {
}
