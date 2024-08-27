package com.pjsoft.fms.controller;

import com.pjsoft.fms.model.Schedule;
import com.pjsoft.fms.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    // 1. Get All the schedules
    @GetMapping
    public List<Schedule> getAllSchedules(){
        return scheduleService.getAllSchedules();
    }

    // 2. Get schedule details by id
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getScheduleById(@PathVariable Long id){
//        Schedule schedule = scheduleService.getScheduleById(id);
//        return ResponseEntity.ok(schedule);
//    }
    @GetMapping("/{id}")
    public Schedule getScheduleById(@PathVariable Long id){
        return scheduleService.getScheduleById(id);
    }

    // 3. Create and save schedule details
    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule){
        return scheduleService.saveSchedule(schedule);
    }

    // 4. Create and save multiple schedule details
//    @PostMapping
//    public List<Schedule> createAllSchedules(@RequestBody List<Schedule> scheduleLists){
//        return scheduleService.saveAllSchedules(scheduleLists);
//    }

    // 4. Update schedule details
    @PutMapping("/{id}")
    public Schedule updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule){
        schedule.setId(id);
        return scheduleService.saveSchedule(schedule);
    }

    // 5. Delete Schedule details
    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id){
        scheduleService.deleteSchedule(id);
    }
}
