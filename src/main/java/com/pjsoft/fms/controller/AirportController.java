package com.pjsoft.fms.controller;

import com.pjsoft.fms.model.Airport;
import com.pjsoft.fms.service.AirportService;
import com.pjsoft.fms.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

    @Autowired
    private AirportService airportService;
    
    @GetMapping
    public List<Airport> getAllAirports(){
        return airportService.getAllAirports();
    }

    // 2. Get Airport details by id
//    @GetMapping("/{id}")
//    public ResponseEntity<Object> getAirportById(@PathVariable Long id){
//        Airport Airport = AirportService.getAirportById(id);
//        return ResponseEntity.ok(Airport);
//    }
    @GetMapping("/{id}")
    public Airport getAirportById(@PathVariable Long id){
        return airportService.getAirportById(id);
    }

    // 3. Create and save Airport details
    @PostMapping
    public Airport createAirport(@RequestBody Airport Airport){
        return airportService.saveAirport(Airport);
    }

    // 4. Create and save multiple Airport details
//    @PostMapping
//    public List<Airport> createAllAirports(@RequestBody List<Airport> AirportLists){
//        return airportService.saveAllAirports(AirportLists);
//    }

    // 4. Update Airport details
    @PutMapping("/{id}")
    public Airport updateAirport(@PathVariable Long id, @RequestBody Airport Airport){
        Airport.setId(id);
        return airportService.saveAirport(Airport);
    }

    // 5. Delete Airport details
    @DeleteMapping("/{id}")
    public void deleteAirport(@PathVariable Long id){
        airportService.deleteAirport(id);
    }
}
