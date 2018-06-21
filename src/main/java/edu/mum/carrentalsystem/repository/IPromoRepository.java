package edu.mum.carrentalsystem.repository;

import edu.mum.carrentalsystem.model.rent.Promo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPromoRepository extends JpaRepository<Promo,Long> {
}
