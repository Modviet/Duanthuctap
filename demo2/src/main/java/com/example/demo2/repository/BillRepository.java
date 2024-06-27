package com.example.demo2.Repository;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo2.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer>{
	@Query("SELECT SUM(b.price) FROM Bill b")
	BigDecimal findtoTotalSales();
	
	@Query("SELECT b.course.id, COUNT(b.id) AS courseCount FROM Bill b GROUP BY b.course.id ORDER BY courseCount DESC")
	List<Object[]> findMostRegisteredCourses(Pageable pageable);
}
