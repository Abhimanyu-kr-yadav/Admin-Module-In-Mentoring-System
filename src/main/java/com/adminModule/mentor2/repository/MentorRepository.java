package com.adminModule.mentor2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adminModule.mentor2.model.Mentor;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {

}
