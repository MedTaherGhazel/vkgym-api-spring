package com.vikings.gym.repository;

import com.vikings.gym.model.Day;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DayRepository extends JpaRepository<Day,Long> {
}
