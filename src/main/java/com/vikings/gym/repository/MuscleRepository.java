package com.vikings.gym.repository;

import com.vikings.gym.model.Muscle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MuscleRepository extends JpaRepository<Muscle,Long> {
}
