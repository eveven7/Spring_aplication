package com.swedbank.StudentApplication.school.model;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("school")
//@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService service;

    public SchoolController(SchoolService service){
        this.service = service;
    }

    @GetMapping("/buildings")
    public List<Building> allBuildings() {return service.allBuildings();}

    @GetMapping("/buildings/{buildingId}/rooms")
    public List<ClassRoom> getBuildingRooms(@PathVariable final int buildingId){
        return service.getBuildingRooms(buildingId);
    }

    @PutMapping("/classroom/{buildingId}/rooms/{roomId}")
    public ClassRoom addClassRoom(@RequestBody ClassRoom room, @PathVariable int buildingId, @PathVariable long roomId){
        return service.addClassRoom(room, buildingId, roomId);
    }
    @GetMapping("/{id}")
    public Building get(@PathVariable final int id){
        return service.getOneBuilding(id);
    }



}