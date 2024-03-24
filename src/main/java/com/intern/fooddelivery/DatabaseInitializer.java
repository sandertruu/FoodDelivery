package com.intern.fooddelivery;

import com.intern.fooddelivery.model.RegionalBaseFee;
import com.intern.fooddelivery.model.Station;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

    }


    public void insertMovie(Station station) throws SQLException {

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

    public void insertSchedule(RegionalBaseFee regionalBaseFee) throws SQLException {

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
