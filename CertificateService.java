package com.example.demo2.service;


import com.example.demo2.model.Certificate;
import com.example.demo2.repository.CertificateRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateService {

    @Autowired
    private CertificateRepos certiRepo;

    public List<Certificate> getData(){
        return certiRepo.findAll();
    }

    public Optional<Certificate> getCertificateById(int id){
        return certiRepo.findById(id);
    }

    public Certificate createCertificate(Certificate certificate){
        return certiRepo.save(certificate);
    }

    public Certificate updateCertificate(int id,Certificate certificate){
        Certificate newCertifi = certiRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Certificate not found"));

        newCertifi.setCertificateTypeId(certificate.getCertificateTypeId());
        newCertifi.setName(certificate.getName());
        newCertifi.setDescription(certificate.getDescription());
        newCertifi.setImage(certificate.getImage());

        return certiRepo.save(newCertifi);
    }

    public void deleteCertificate(int id){
        Certificate certi = certiRepo.findById(id)
                .orElseThrow(()->new RuntimeException("Certificate not found"));
        certiRepo.delete(certi);
    }
}
