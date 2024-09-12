package com.example.result.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.result.entity.MarksheetDetails;

@Repository
public interface MarksheetDetailsRepo extends JpaRepository<MarksheetDetails, Long>
{
	MarksheetDetails findOneByIdMarksheetAndIdSubject(Long idMarksheet, Long idSubject);
	List<MarksheetDetails> findByIdMarksheet(Long idMarksheet);

}
