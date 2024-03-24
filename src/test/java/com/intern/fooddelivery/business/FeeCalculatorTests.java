package com.intern.fooddelivery.business;


import com.intern.fooddelivery.dto.CalculatedFeeDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FeeCalculatorTests {

    @Test
    public void CalculateFee_Without_Extra_Fees(){
        FeeCalculator feeCalculator = FeeCalculator.builder().vehicle("car")
                .basefee(4).temperature(3.0).phenomenon("sunny").windspeed(2.0)
                .build();
        double fee = feeCalculator.calulateFee().getFee();

        Assertions.assertEquals(4, fee);
    }

    @Test
    public void CalculateFee_Bike_Rain(){
        FeeCalculator feeCalculator = FeeCalculator.builder().vehicle("bike")
                .basefee(4).temperature(3.0).phenomenon("rain").windspeed(2.0)
                .build();
        double fee = feeCalculator.calulateFee().getFee();

        Assertions.assertEquals(4.5, fee);
    }

    @Test
    public void CalculateFee_Scooter_Sleet(){
        FeeCalculator feeCalculator = FeeCalculator.builder().vehicle("scooter")
                .basefee(4).temperature(3.0).phenomenon("sleet").windspeed(2.0)
                .build();
        double fee = feeCalculator.calulateFee().getFee();

        Assertions.assertEquals(5, fee);
    }

    @Test
    public void CalculateFee_Bike_Thunder(){
        FeeCalculator feeCalculator = FeeCalculator.builder().vehicle("bike")
                .basefee(4).temperature(3.0).phenomenon("thunder").windspeed(2.0)
                .build();
        CalculatedFeeDTO calculatedFee = feeCalculator.calulateFee();
        double fee = calculatedFee.getFee();
        String message = calculatedFee.getError();

        Assertions.assertEquals(0, fee);
        Assertions.assertNotEquals("", message);
    }

    @Test
    public void CalculateFee_Bike_WindGreaterThan20(){
        FeeCalculator feeCalculator = FeeCalculator.builder().vehicle("bike")
                .basefee(4).temperature(3.0).phenomenon("sunny").windspeed(23.0)
                .build();

        CalculatedFeeDTO calculatedFee = feeCalculator.calulateFee();
        double fee = calculatedFee.getFee();
        String message = calculatedFee.getError();

        Assertions.assertEquals(0, fee);
        Assertions.assertNotEquals("", message);
    }

    @Test
    public void CalculateFee_Bike_WindspeedBetween_10_and_20(){
        FeeCalculator feeCalculator = FeeCalculator.builder().vehicle("bike")
                .basefee(4).temperature(3.0).phenomenon("sunny").windspeed(14.0)
                .build();
        double fee = feeCalculator.calulateFee().getFee();

        Assertions.assertEquals(4.5, fee);
    }

    @Test
    public void CalculateFee_Scooter_Temperature_Under_Minus10(){
        FeeCalculator feeCalculator = FeeCalculator.builder().vehicle("scooter")
                .basefee(4).temperature(-13.0).phenomenon("cloudy").windspeed(14.0)
                .build();
        double fee = feeCalculator.calulateFee().getFee();

        Assertions.assertEquals(5, fee);
    }

    @Test
    public void CalculateFee_Scooter_Temperature_Under_0(){
        FeeCalculator feeCalculator = FeeCalculator.builder().vehicle("scooter")
                .basefee(4).temperature(-3.0).phenomenon("cloudy").windspeed(14.0)
                .build();
        double fee = feeCalculator.calulateFee().getFee();

        Assertions.assertEquals(4.5, fee);
    }
    
}
