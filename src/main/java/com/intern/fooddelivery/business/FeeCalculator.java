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
public class FeeCalculator {

    private String vehicle;

    private double basefee;

    private double temperature;

    private double windspeed;

    private String phenomenon;


    public CalculatedFeeDTO calulateFee(){
        double total = basefee;
        double atef = 0;
        double wsef = 0;
        double wpef = 0;
        String error = "";
        long id = ThreadLocalRandom.current().nextLong(100);
        if (vehicle.equals("scooter") || vehicle.equals("bike")){
            if (temperature < -10){
                atef = 1;
            } else if (temperature <= 0) {
                atef = 0.5;
            }else{
                atef = 0;
            }

            if (phenomenon.equals("snow") || phenomenon.equals("sleet")){
                wpef = 1;
            } else if (phenomenon.equals("rain")) {
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
