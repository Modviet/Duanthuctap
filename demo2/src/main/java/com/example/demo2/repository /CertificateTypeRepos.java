package com.example.demo2.repository;

import com.example.demo2.model.CertificateType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateTypeRepos extends JpaRepository<CertificateType,Integer> {
}
