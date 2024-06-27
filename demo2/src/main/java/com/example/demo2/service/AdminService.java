package com.example.demo2.Service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo2.Exception.ResourceNotFoundException;
import com.example.demo2.Repository.BillRepository;


@Service
public class AdminService {
	@Autowired
	private BillRepository billRepo;
//	Thống kê doanh số
	public BigDecimal getTotalSale() {
		 BigDecimal totalSales = billRepo.findtoTotalSales();
	        if (totalSales == null) {
	            throw new ResourceNotFoundException("No sales data found.");
	        }
	        return totalSales;
	}
//	Khóa học được đăng ký nhiều nhất
	public List<Object[]> getMostRegisteredCourses(int limit) {
		 List<Object[]> courses = billRepo.findMostRegisteredCourses(PageRequest.of(0, limit));
	        if (courses.isEmpty()) {
	            throw new ResourceNotFoundException("No registered courses found.");
	        }
	        return courses;
    }
}
