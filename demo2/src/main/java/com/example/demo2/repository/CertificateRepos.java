package com.example.demo2.repository;

import com.example.demo2.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateRepos extends JpaRepository<Certificate,Integer> {

}
