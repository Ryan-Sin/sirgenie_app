package com.sirgenie.sirgenie_app.repository;

import com.sirgenie.sirgenie_app.domain.Banking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankingRepository extends JpaRepository<Banking, Long> {
}
