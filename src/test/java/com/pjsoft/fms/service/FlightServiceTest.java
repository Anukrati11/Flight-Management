package com.pjsoft.fms.service;

import com.pjsoft.fms.model.Flight;
import com.pjsoft.fms.repository.jpa.FlightRepository;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Optional;

@SpringBootTest
public class FlightServiceTest {

    @InjectMocks
    private FlightService flightService;

    @Mock
    private FlightRepository flightRepository;

    @Test
    public void getFlightByIdOk(){
        // Prepare
        Long id = 20L;
        Flight flight = Mockito.mock(Flight.class);
        Mockito.when(flightRepository.findById(id)).thenReturn(Optional.ofNullable(flight));

        // Execute
        Flight res = flightService.getFlightById(id);

        // Validate
        Assert.notNull(res);
        Assertions.assertEquals(res, flight);

    }
}
