package com.intern.fooddelivery.business;

import com.intern.fooddelivery.dto.CalculatedFeeDTO;
import com.intern.fooddelivery.exceptions.VehicleTypeForbiddenException;
import lombok.*;

import java.util.concurrent.ThreadLocalRandom;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class FeeCalculator {

    private String vehicle;

    private double basefee;

    private double temperature;

    private double windspeed;

    private String phenomenon;

    /**
     * Method to calculate the total delivery fee taking into account base fee and checking for weather condition based fees
     * @return Calculated fee DTO with a possible error message or "" if there is no error, fee is 0 when there is illegal vehicle type
     */
    public CalculatedFeeDTO calulateFee(){
        double total = basefee;
        double atef = 0;
        double wsef = 0;
        double wpef = 0;
        String error = "";
        //Since the application is small, generate a random ID in the range until 100 for the
        //CalculatedFee DTO
        long id = ThreadLocalRandom.current().nextLong(100);
        //Did not manage to move the weather conditions into entity level
        //So this part checks the vehicle type and then weather parameters in order to calculate
        //additional fees
        if (vehicle.equals("scooter") || vehicle.equals("bike")){
            if (temperature < -10){
                atef = 1;
            } else if (temperature <= 0) {
                atef = 0.5;
            }else{
                atef = 0;
            }

            if (phenomenon.contains("snow") || phenomenon.contains("sleet")){
                wpef = 1;
            } else if (phenomenon.contains("rain") || phenomenon.contains("shower")) {
                wpef = 0.5;
            } else if (phenomenon.equals("glaze") || phenomenon.equals("hail") || phenomenon.equals("thunder")) {
                return new CalculatedFeeDTO(id, 0,
                        String.valueOf(new VehicleTypeForbiddenException("Weather phenomenon: " + phenomenon + " , vehicle type '"
                        + vehicle + "' is forbidden!")));
            }

        }
        
        if(vehicle.equals("bike") && windspeed >= 10 && windspeed <= 20){
            wsef = 0.5;
        } else if (vehicle.equals("bike") && windspeed > 20) {
            return new CalculatedFeeDTO(id, 0,
                    String.valueOf(new VehicleTypeForbiddenException("Windspeed over 20m/s, vehicle type 'bike' is forbidden!")));
        }else {
            wsef = 0;
        }
        total = total + atef + wsef + wpef;
        return new CalculatedFeeDTO(id, total, error);
    }

}
