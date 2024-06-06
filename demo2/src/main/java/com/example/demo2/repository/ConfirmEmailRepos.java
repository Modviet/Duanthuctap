package com.example.demo2.repository;

import com.example.demo2.model.ConfirmEmail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConfirmEmailRepos extends JpaRepository<ConfirmEmail,Integer> {
    @Query("SELECT c FROM ConfirmEmail c WHERE c.confirmCode = :confirmCode")
    Optional<ConfirmEmail> findByConfirmCode(@Param("confirmCode") String confirmCode);
}
