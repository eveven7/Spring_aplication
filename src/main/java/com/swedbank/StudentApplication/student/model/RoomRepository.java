package com.swedbank.StudentApplication.student.model;

import com.swedbank.StudentApplication.school.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<ClassRoom, Long> {

}
