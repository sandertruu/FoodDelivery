package com.intern.fooddelivery.repository;

import com.intern.fooddelivery.model.Station;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class StationRepositoryTests {
    @Autowired
    private StationRepo stationRepo;

    @Test
    public void StationRepo_SaveAll_ReturnSavedWeather(){
        Station weather = Station.builder().station("Tallinn")
                .wmo(12345L).temperature(3.0).windspeed(5.0)
                .phenomenon("rain").timestamp("2024-03-24 13:00:00").build();

        Station savedStation = stationRepo.save(weather);

        Assertions.assertThat(savedStation).isNotNull();
        Assertions.assertThat(savedStation.getId()).isGreaterThan(0);
    }

    @Test
    public void StationRepo_GetAll_ReturnMoreThanOneStationData(){
        Station weather1 = Station.builder().station("Tallinn")
                .wmo(12345L).temperature(3.0).windspeed(5.0)
                .phenomenon("rain").timestamp("2024-03-24 13:00:00").build();
        Station weather2 = Station.builder().station("Tartu")
                .wmo(12365L).temperature(4.0).windspeed(3.0)
                .phenomenon("snow").timestamp("2024-03-24 13:00:00").build();

        stationRepo.save(weather1);
        stationRepo.save(weather2);

        List<Station> stations = stationRepo.findAll();

        Assertions.assertThat(stations).isNotNull();
        Assertions.assertThat(stations.size()).isEqualTo(2);
    }
}
