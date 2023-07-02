package com.example.LoginRegisterEmail.registration.token;

import com.example.LoginRegisterEmail.jwt.JwtTokenUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository <Confirmation,Long> {

    Optional <Confirmation> findByToken(String token);

    @Transactional
    @Modifying
    @Query("UPDATE Confirmation c " +
            "SET c.confirmedAt = ?2 " +
            "WHERE c.token = ?1")
    int updateConfirmedAt(String token,
                          LocalDateTime confirmedAt);
}
