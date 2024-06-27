package com.example.demo2.Controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo2.Exception.InvalidInputException;
import com.example.demo2.Service.AdminService;

@RestController
@RequestMapping(value="admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/sales")
    public ResponseEntity<BigDecimal> getTotalSales() {
        return ResponseEntity.ok(adminService.getTotalSale());
    }

    @GetMapping("/most-registered-courses")
    public ResponseEntity<List<Object[]>> getMostRegisteredCourses(@RequestParam(defaultValue = "10") int limit) {
        if (limit <= 0) {
            throw new InvalidInputException("Limit must be greater than zero.");
        }
        return ResponseEntity.ok(adminService.getMostRegisteredCourses(limit));
    }
}
