package com.intern.fooddelivery.repository;

import com.intern.fooddelivery.model.RegionalBaseFee;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RegionalBaseFeeRepositoryTests {
    @Autowired
    private RegionalBaseFeeRepo regionalBaseFeeRepo;

    @Test
    public void RBFRepo_SaveAll_ReturnSavedRBF(){

        RegionalBaseFee rbf = RegionalBaseFee.builder().city("Tallinn")
                .vehicle("bike").fee(3).build();

        RegionalBaseFee savedRBF = regionalBaseFeeRepo.save(rbf);

        Assertions.assertThat(savedRBF).isNotNull();
        Assertions.assertThat(savedRBF.getId()).isGreaterThan(0);
    }

    @Test
    public void RBFRepo_GetALL_ReturnMoreThanOneRBF(){
        RegionalBaseFee rbf1 = RegionalBaseFee.builder().city("Tallinn")
                .vehicle("bike").fee(3).build();
        RegionalBaseFee rbf2 = RegionalBaseFee.builder().city("Tartu")
                .vehicle("car").fee(3.5).build();

        regionalBaseFeeRepo.save(rbf1);
        regionalBaseFeeRepo.save(rbf2);

        List<RegionalBaseFee> rbfs = regionalBaseFeeRepo.findAll();

        Assertions.assertThat(rbfs).isNotNull();
        Assertions.assertThat(rbfs.size()).isEqualTo(2);

    }

    @Test
    public void RBFRepo_UpdateBaseFee_ReturnRBFNotNull(){
        RegionalBaseFee rbf1 = RegionalBaseFee.builder().city("Tallinn")
                .vehicle("bike").fee(3).build();

        regionalBaseFeeRepo.save(rbf1);
        RegionalBaseFee regionalBaseFee = regionalBaseFeeRepo.findById(rbf1.getId()).get();
        regionalBaseFee.setFee(5);

        RegionalBaseFee updateFee = regionalBaseFeeRepo.save(regionalBaseFee);

        Assertions.assertThat(updateFee.getFee()).isNotNull();
        Assertions.assertThat(updateFee.getFee()).isEqualTo(5);
    }

    @Test
    public void RBFRepo_DeleteFee_ReturnRBFIsEmpty(){
        RegionalBaseFee rbf1 = RegionalBaseFee.builder().city("Tallinn")
                .vehicle("bike").fee(3).build();

        regionalBaseFeeRepo.save(rbf1);

        regionalBaseFeeRepo.deleteById(rbf1.getId());

        Optional<RegionalBaseFee> rbf = regionalBaseFeeRepo.findById(rbf1.getId());

        Assertions.assertThat(rbf).isEmpty();
    }
}
