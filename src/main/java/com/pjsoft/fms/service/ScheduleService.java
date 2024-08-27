package com.pjsoft.fms.service;

import com.pjsoft.fms.exception.ResourceNotFoundException;
import com.pjsoft.fms.model.Schedule;
import com.pjsoft.fms.repository.jpa.ScheduleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;

    private static final Logger logger = LoggerFactory.getLogger(ScheduleService.class);

    // 1. Get All the schedules
    public List<Schedule> getAllSchedules(){
        return scheduleRepository.findAll();
    }

    // 2. Get schedule details by id
    public Schedule getScheduleById(Long scheduleId){
        logger.debug("Please wait, Searching the schedule of given Id!");
        return scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ResourceNotFoundException("Schedule not found with id: "+scheduleId));
    }

    // 3. Save schedule details
    public Schedule saveSchedule(Schedule schedule){
        return scheduleRepository.save(schedule);
    }

//    // Save all schedules details
//    public List<Schedule> saveAllSchedules(List<Schedule> scheduleList){
//        return scheduleRepository.saveAll(scheduleList);
//    }

    // 4. Delete FLight details
    public void deleteSchedule(long scheduleId){
        scheduleRepository.deleteById(scheduleId);
    }



}
