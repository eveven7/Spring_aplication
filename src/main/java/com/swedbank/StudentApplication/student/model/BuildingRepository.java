package com.swedbank.StudentApplication.student.model;

import com.swedbank.StudentApplication.school.model.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {

}
