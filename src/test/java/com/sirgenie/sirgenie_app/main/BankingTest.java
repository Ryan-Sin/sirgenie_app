package com.sirgenie.sirgenie_app.main;

import com.sirgenie.sirgenie_app.domain.Banking;
import com.sirgenie.sirgenie_app.repository.BankingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BankingTest {

    @Autowired
    private BankingRepository bankingRepository;

    @Test
    public void BankingSaveAndFindTest() {

        String period = "2021";
        Double utilization = 99.9;
        Double phone = 22.2;
        Double note_book = 11.1;

        //given
        bankingRepository.save(new Banking(period, utilization, phone, note_book));

        //when
        List<Banking> bankingList = bankingRepository.findAll();

        Banking banking = bankingList.get(7);

        //then
        assertThat(banking.getPeriod()).isEqualTo(period);
    }
}
