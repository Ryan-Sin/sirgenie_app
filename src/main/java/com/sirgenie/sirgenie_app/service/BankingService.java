package com.sirgenie.sirgenie_app.service;

import com.sirgenie.sirgenie_app.domain.Banking;
import com.sirgenie.sirgenie_app.repository.BankingRepository;
import com.sirgenie.sirgenie_app.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankingService {

    @Autowired
    private BankingRepository bankingRepository;

    public Response getAll(){

        List<Banking> banking = bankingRepository.findAll();

        return new Response(true, "데이터 정보", banking);
    }
}
