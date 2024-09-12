package com.example.result.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.result.entity.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long>{

}
