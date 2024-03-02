package com.davr7.msemployee.repositories;

import com.davr7.msemployee.domain.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, String> {
}
