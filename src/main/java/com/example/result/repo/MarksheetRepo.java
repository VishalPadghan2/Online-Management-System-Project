package com.example.result.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.result.entity.Marksheet;

@Repository
public interface MarksheetRepo extends JpaRepository<Marksheet, Long> 
{
	Marksheet findOneByIdStudent(Long idStudent);

}
