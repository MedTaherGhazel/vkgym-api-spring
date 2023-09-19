package com.vikings.gym.repository;

import com.vikings.gym.model.Day;
import com.vikings.gym.repository.projection.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DayRepository extends JpaRepository<Day,Long> {
    @Query("select "+
            "d.day as day, d.restDay as restDay  "+
            " from Day d , Week w  "+
            "where w.id = :weekId")
    List<PurchaseItem> finAllDaysOfWeek(@Param("weekId") Long weekId);
}
