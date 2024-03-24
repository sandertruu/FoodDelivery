package com.intern.fooddelivery;

import com.intern.fooddelivery.model.RegionalBaseFee;
import com.intern.fooddelivery.model.Station;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Component
public class DatabaseInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        RegionalBaseFee[] rbfs = {
                new RegionalBaseFee(1L, "Tallinn", "car", 4),
                new RegionalBaseFee(2L, "Tallinn", "scooter", 3.5),
                new RegionalBaseFee(3L, "Tallinn", "bike", 3),
                new RegionalBaseFee(4L, "Tartu", "car", 3.5),
                new RegionalBaseFee(5L, "Tartu", "scooter", 3),
                new RegionalBaseFee(6L, "Tartu", "bike", 2.5),
                new RegionalBaseFee(7L, "Pärnu", "car", 3),
                new RegionalBaseFee(8L, "Pärnu", "scooter", 2.5),
                new RegionalBaseFee(9L, "Pärnu", "bike", 2)
        };

        for (RegionalBaseFee rbf : rbfs) {
            try {
                insertBaseFee(rbf);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void insertWeather(Station station) throws SQLException {

        String query = "INSERT INTO weather_by_stations(station, wmo, temperature, windspeed, phenomenon, timestamp) VALUES (?,?,?,?,?,?)";

        Connection con = DriverManager.getConnection("jdbc:h2:mem:fooddeliverydb", "admin", "test");
        PreparedStatement stmt = con.prepareStatement(query);

        stmt.setString(1, station.getStation());
        stmt.setLong(2, station.getWmo());
        stmt.setDouble(3, station.getTemperature());
        stmt.setDouble(4, station.getWindspeed());
        stmt.setString(5, station.getPhenomenon());
        stmt.setString(6, station.getTimestamp());

        stmt.executeUpdate();
        con.close();

    }

    public void insertBaseFee(RegionalBaseFee regionalBaseFee) throws SQLException {

        String query = "INSERT INTO regional_base_fee(city, vehicle, fee) VALUES (?,?,?)";

        Connection con = DriverManager.getConnection("jdbc:h2:mem:fooddeliverydb", "admin", "test");
        PreparedStatement stmt = con.prepareStatement(query);

        stmt.setString(1, regionalBaseFee.getCity());
        stmt.setString(2, regionalBaseFee.getVehicle());
        stmt.setDouble(3, regionalBaseFee.getFee());

        stmt.executeUpdate();
        con.close();

    }


}
