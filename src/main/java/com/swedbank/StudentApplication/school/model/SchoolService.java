package com.swedbank.StudentApplication.student.model;

import com.swedbank.StudentApplication.school.exception.RoomsNotFound;
import com.swedbank.StudentApplication.school.model.Building;
import com.swedbank.StudentApplication.school.model.ClassRoom;
import com.swedbank.StudentApplication.school.exception.BuildingNotFoundException;
import com.swedbank.StudentApplication.student.model.Building;
import com.swedbank.StudentApplication.student.model.BuildingRepository;
import com.swedbank.StudentApplication.student.model.ClassRoom;
import com.swedbank.StudentApplication.student.model.RoomRepository;
import com.swedbank.StudentApplication.student.model.exception.BuildingNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
//class should be loaded to the container
@Service
//implements constructor just for private final fields, they should be initialize
@RequiredArgsConstructor
public class SchoolService {

    private final BuildingRepository buildingRepository;

    private final RoomRepository roomRepository;

    public List<Building> allBuildings() {return buildingRepository.findAll();}


    public List<ClassRoom> getBuildingRooms(int id){
        var building = buildingRepository.findById(id).orElseThrow(() -> new RoomsNotFound(id));

        return building.getRoomSet();
    }

    public ClassRoom addClassRoom(ClassRoom newRoom, int buildingId, long roomId) {
        Building building = buildingRepository.findById(buildingId).orElseThrow(() -> new BuildingNotFoundException(buildingId));
        return roomRepository.findById(roomId).map(room -> {
            room.setName(newRoom.getName());
            room.setCapacity(newRoom.getCapacity());
            room.setFloor(newRoom.getFloor());
            room.setBuilding(building);
            return roomRepository.save(room);
        }).orElseGet(() ->{newRoom.setId(roomId);
            newRoom.setBuilding(building);
            return roomRepository.save(newRoom);
        });
    }
}