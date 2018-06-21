package edu.mum.carrentalsystem.service.rentFeeHandler;

import edu.mum.carrentalsystem.model.rent.Promo;
import edu.mum.carrentalsystem.model.rent.RentRecord;
import edu.mum.carrentalsystem.model.vehicle.Vehicle;
import edu.mum.carrentalsystem.repository.IPromoRepository;
import edu.mum.carrentalsystem.repository.IVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


public class RentReturnlDirector {


  private IPromoRepository promoRepository;
    private IRentRecordBuilder rentRecordBuilder=null;

    private IVehicleRepository vehicleRepository;
    private RentRecord r;

    public RentReturnlDirector(IRentRecordBuilder rentRecordBuilder,IPromoRepository promoRepository,IVehicleRepository vehicleRepository) {
        this.rentRecordBuilder = rentRecordBuilder;
        this.promoRepository=promoRepository;
        this.vehicleRepository=vehicleRepository;
    }
    public void performCheckout() {
     r =rentRecordBuilder.intialize();
        Promo promo=rentRecordBuilder.buildPromo();
      if(promo!=null){

         promoRepository.save(promo);
         r.setPromo(promo);

      }
        Vehicle v=rentRecordBuilder.buildVehicle(r);
      vehicleRepository.save(v);

    }
    public RentRecord getRecord() {
        return rentRecordBuilder.getRentRecord(r);
    }
}
