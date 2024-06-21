package com.example.demo2.controller;

import com.example.demo2.model.Certificate;
import com.example.demo2.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/certificate")
public class CertificateController {

    @Autowired
    private CertificateService cerService;

    @GetMapping
    public ResponseEntity<List<Certificate>> getAll(){
        List<Certificate> danhsach = cerService.getData();
        return new ResponseEntity<>(danhsach, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Certificate> getCertificateById(@PathVariable int id){
        Optional<Certificate> certificate = cerService.getCertificateById(id);
        if(certificate.isPresent()){
            return ResponseEntity.ok(certificate.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Certificate> createCertificate(@RequestBody Certificate certificate){
        Certificate newCerti = cerService.createCertificate(certificate);
        return new ResponseEntity<>(newCerti,HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Certificate> updateCertificate(@PathVariable int id,
                                                         @RequestBody Certificate certificate){
        Optional<Certificate> existingCertificateOpt = cerService.getCertificateById(id);
        if (!existingCertificateOpt.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Certificate existingCertificate = existingCertificateOpt.get();
        existingCertificate.setCertificateTypeId(certificate.getCertificateTypeId());
        existingCertificate.setName(certificate.getName());
        existingCertificate.setDescription(certificate.getDescription());
        existingCertificate.setImage(certificate.getImage());

        Certificate updatedCertificate = cerService.updateCertificate(id, existingCertificate);
        return ResponseEntity.ok(updatedCertificate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCertificate(@PathVariable int id){
        cerService.deleteCertificate(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
