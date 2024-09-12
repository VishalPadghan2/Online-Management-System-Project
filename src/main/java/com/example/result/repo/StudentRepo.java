package com.example.result.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.result.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
	Student findBySeatNoAndMotherName(String seatNo, String motherName);

}
