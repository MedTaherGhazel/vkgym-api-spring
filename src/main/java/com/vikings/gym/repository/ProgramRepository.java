package com.vikings.gym.repository;

import com.vikings.gym.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Program,Long> {

}
