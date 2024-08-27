package com.pjsoft.fms.controller;

import com.pjsoft.fms.model.ScheduledFlight;
import com.pjsoft.fms.service.ScheduledFlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scheduledFlight")
public class ScheduledFlightController {

    @Autowired
    private ScheduledFlightService scheduledFlightService;

    // 1. Get All the scheduledFlights
    @GetMapping
    public List<ScheduledFlight> getAllScheduledFlights(){
        return scheduledFlightService.getAllScheduledFlights();
    }

    // 2. Get scheduledFlight details by id
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getScheduledFlightById(@PathVariable Long id){
//        ScheduledFlight scheduledFlight = scheduledFlightService.getScheduledFlightById(id);
//        return ResponseEntity.ok(scheduledFlight);
//    }
    @GetMapping("/{id}")
    public ScheduledFlight getScheduledFlightById(@PathVariable Long id){
        return scheduledFlightService.getScheduledFlightsById(id);
    }

    // 3. Create and save scheduledFlight details
    @PostMapping
    public ScheduledFlight createScheduledFlight(@RequestBody ScheduledFlight scheduledFlight){
        return scheduledFlightService.saveScheduledFlights(scheduledFlight);
    }

    // 4. Create and save multiple scheduledFlight details
//    @PostMapping
//    public List<ScheduledFlight> createAllScheduledFlights(@RequestBody List<ScheduledFlight> scheduledFlightLists){
//        return scheduledFlightService.saveAllScheduledFlights(scheduledFlightLists);
//    }

    // 4. Update scheduledFlight details
    @PutMapping("/{id}")
    public ScheduledFlight updateScheduledFlight(@PathVariable Long id, @RequestBody ScheduledFlight scheduledFlight){
        scheduledFlight.setId(id);
        return scheduledFlightService.saveScheduledFlights(scheduledFlight);
    }

    // 5. Delete ScheduledFlight details
    @DeleteMapping("/{id}")
    public void deleteScheduledFlight(@PathVariable Long id){
        scheduledFlightService.deleteScheduledFlight(id);
    }
}
